public class ComunicadoDeResultado extends Comunicado {
  private final String palavra;
  private final boolean jogadorGanhou;

  public ComunicadoDeResultado(String palavra, boolean jogadorGanhou) {
    this.palavra = palavra;
    this.jogadorGanhou = jogadorGanhou;
  }

  public String getPalavra() {
    return palavra;
  }

  public boolean isJogadorGanhou() {
    return jogadorGanhou;
  }
}
