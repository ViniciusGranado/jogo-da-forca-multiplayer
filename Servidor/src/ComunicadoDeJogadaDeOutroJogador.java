public class ComunicadoDeJogadaDeOutroJogador extends Comunicado {
  private final String letrasJaDigitadas;
  private final String tracinhos;

  public ComunicadoDeJogadaDeOutroJogador(String letrasJaDigitadas, String tracinhos) {
    this.letrasJaDigitadas = letrasJaDigitadas;
    this.tracinhos = tracinhos;
  }

  public String getLetrasJaDigitadas() {
    return this.letrasJaDigitadas;
  }

  public String getTracinhos() {
    return this.tracinhos;
  }
}
