public class TratadoraDeComunicadoDeDesligamento extends Thread {
  private Parceiro servidor;

  public TratadoraDeComunicadoDeDesligamento(Parceiro servidor) throws Exception {
    if (servidor == null)
      throw new Exception("Porta invalida");

    this.servidor = servidor;
  }

  public void run() {
    Comunicado comunicado = null;

    for (;;) {
      try {
        comunicado = servidor.espie();
      } catch (Exception erro) {
        continue;
      }

      if (comunicado instanceof ComunicadoDeDesligamento) {
        System.out.println("\nO servidor vai ser desligado agora;");
        System.exit(0);
      }

      if (comunicado instanceof ComunicadoDeResultado) {
        ComunicadoDeResultado resultado = null;

        try {
          resultado = (ComunicadoDeResultado) servidor.envie();

          boolean jogadorGanhou = resultado.isJogadorGanhou();
          String palavra = resultado.getPalavra();

          Terminal.clear();

          if (jogadorGanhou) {
            System.out.println("PARABENS, VOCE VENCEU");
          } else {
            System.out.println("Que pena, voce perdeu");
          }

          System.out.println("A palavra era " + palavra + "\n");
        } catch (Exception erro) {
          //
        }

        System.exit(0);
      }
    }
  }
}
