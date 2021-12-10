import java.util.ArrayList;

public class Partida extends Thread {
  private ArrayList<Parceiro> jogadores;
  private Palavra palavra;
  private Tracinhos tracinhos;
  private ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas;

  public Partida(ArrayList<Parceiro> jogadores) {
    this.jogadores = jogadores;

    this.palavra = BancoDePalavras.getPalavraSorteada();
    this.controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();

    try {
      this.tracinhos = new Tracinhos(this.palavra.getTamanho());
    } catch(Exception erro) {
      System.out.println(erro.getMessage());
    }
  }

  public void run() {
    synchronized(jogadores) {
      for (Parceiro jogador : jogadores) {
        try {
          jogador.receba(new ComunicadoDeInicioDePartida());
        } catch (Exception erro) {
          //
        }
      }

      boolean partidaTerminou = false;
      do {
        for (Parceiro jogador : jogadores) {
          try {
            jogador.receba(new ComunicadoDeVezDoJogador(this.controladorDeLetrasJaDigitadas.toString(), this.tracinhos.toString()));
          } catch (Exception erro) {
            System.out.println("Erro no comunicado vez do jogador");
          }

          try {
            Comunicado comunicado = null;
            do {
              comunicado = jogador.envie();
            } while (!(comunicado instanceof TentativaDePalavra) && !(comunicado instanceof TentativaDeLetra));

            if (comunicado instanceof TentativaDePalavra) {
              String palavra = ((TentativaDePalavra) comunicado).getPalavra();
              System.out.println(palavra);
            }

            if (comunicado instanceof TentativaDeLetra) {
              char letra = ((TentativaDeLetra) comunicado).getLetra();

              if (controladorDeLetrasJaDigitadas.isJaDigitada(letra)) {
                jogador.receba(new ComunicadoLetraJaDigitada());
              } else {
                controladorDeLetrasJaDigitadas.registre(letra);

                int qtdLetras = palavra.getQuantidade(letra);

                if (qtdLetras == 0) {
                  jogador.receba(new ComunicadoLetraErrada());
                } else {
                  for (int i = 0; i < qtdLetras; i++) {
                    int posicao = palavra.getPosicaoDaIezimaOcorrencia(i, letra);
                    tracinhos.revele(posicao, letra);
                  }

                  jogador.receba(new ComunicadoLetraCorreta());
                }
              }
            }
          } catch (Exception erro) {
            System.out.println(erro.getMessage());
          }
        }
      } while (!partidaTerminou);

      for (Parceiro jogador : jogadores) {
        System.out.println("DESLIGAMENTO");
        try {
          jogador.receba(new ComunicadoDeDesligamento());
        } catch (Exception erro) {
          //
        }
      }
    }
  }
}
