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
    }
  }
}
