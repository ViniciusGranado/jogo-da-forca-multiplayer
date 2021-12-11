public class ComunicadoDeVezDoJogador extends Comunicado {
  private String letrasJaDigitadas;
  private String tracinhos;

  public ComunicadoDeVezDoJogador(String letrasJaDigitadas, String tracinhos) {
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
