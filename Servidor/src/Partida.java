import java.util.ArrayList;
import java.util.Iterator;

public class Partida extends Thread {
  private final ArrayList<Parceiro> jogadores;
  private final Palavra palavra;
  private Tracinhos tracinhos;
  private final ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas;

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
      boolean terminouPorPalavra = false;

      do {
        Iterator<Parceiro> itr = this.jogadores.iterator();
        while (!partidaTerminou && itr.hasNext()) {
          Parceiro jogador = itr.next();

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

                itr.remove();
              } else {
                jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), false));

                itr.remove();

                if (this.jogadores.size() == 1) {
                  terminouPorPalavra = true;
                  partidaTerminou = true;
                }
              }
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

                    itr.remove();
                  } else {
                    jogador.receba(new ComunicadoLetraCorreta());
                  }
                }
              }
            }

            if (!partidaTerminou) {
              for (Parceiro j : jogadores) {
                try {
//                  if (j != jogador) {
                    j.receba(new ComunicadoDeJogadaDeOutroJogador(this.controladorDeLetrasJaDigitadas.toString(), this.tracinhos.toString()));
//                  }
                } catch (Exception erro) {
                  //
                }
              }
            }
          } catch (Exception erro) {
            System.out.println(erro.getMessage());
          }
        }
      } while (!partidaTerminou);


      if (jogadores.size() == 1 && terminouPorPalavra) {
        for (Parceiro jogador : jogadores) {
          try {
            jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), true));
          } catch (Exception erro) {
            //
          }
        }
      } else {
        for (Parceiro jogador : jogadores) {
          try {
            jogador.receba(new ComunicadoDeResultado(this.palavra.getTexto(), false));
          } catch (Exception erro) {
            //
          }
        }
      }
    }
  }
}
