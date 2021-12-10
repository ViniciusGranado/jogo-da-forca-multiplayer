import java.util.ArrayList;

public class Partida extends Thread {
  private final ArrayList<Parceiro> jogadores;
  private final Palavra palavra;
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
    System.out.println(this.palavra.getTexto());
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

              if (palavra.equals(this.palavra.getTexto())) {
                jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), true));
                partidaTerminou = true;
              } else {
                jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), false));
              }

              this.jogadores.remove(jogador);
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

                  if (!this.tracinhos.isAindaComTracinhos()) {
                    jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), true));
                    partidaTerminou = true;

//                    this.jogadores.remove(jogador);
                  } else {
                    jogador.receba(new ComunicadoLetraCorreta());
                  }
                }
              }
            }
          } catch (Exception erro) {
            System.out.println(erro.getMessage());
          }
        }
      } while (!partidaTerminou);


      if (jogadores.size() == 1) {
        for (Parceiro jogador : jogadores) {
          try {
            jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), true));
//          this.jogadores.remove(jogador);
          } catch (Exception erro) {
            //
          }
        }
      } else {
        for (Parceiro jogador : jogadores) {
          try {
            jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), false));
//          this.jogadores.remove(jogador);
          } catch (Exception erro) {
            //
          }
        }
      }
    }
  }
}
