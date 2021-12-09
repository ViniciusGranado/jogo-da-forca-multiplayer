import java.util.ArrayList;

public class Partida extends Thread {
  private ArrayList<Parceiro> jogadores;
  private String palavra;

  public Partida(ArrayList<Parceiro> jogadores) {
    this.jogadores = jogadores;
    this.palavra = "CASA";
  }

  public void run() {
    ComunicadoDeVezDoJogador comunicadoDeVezDoJogador = new ComunicadoDeVezDoJogador();

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
            jogador.receba(comunicadoDeVezDoJogador);
          } catch (Exception erro) {
            System.out.println("Erro no comunicado vez do jogador");
          }

          try {
            Comunicado comunicado = null;
            do {
              comunicado = jogador.envie();
            } while (!(comunicado instanceof TentativaDePalavra));

            String palavra = ((TentativaDePalavra) comunicado).getPalavra();
            System.out.println(palavra);
          } catch (Exception erro) {
            System.out.println("Erro no loop");
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
