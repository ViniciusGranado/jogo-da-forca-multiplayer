// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package Palavra;

public class Testes {
  public static void main(String[] args) {
    // Testes classe Palavra
    System.out.println("-------------------");
    System.out.println("  CLASSE PALAVRA   ");
    System.out.println("-------------------\n");
  
    Palavra palavra = null;

    //Palavra null
    try {
      palavra = new Palavra(null);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  
    // Palavra string vazia
    try {
      palavra = new Palavra("");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  
    // Palavra valida
    try {
      palavra = new Palavra("teste");
    } catch (Exception e) {}
  
    // Quantidade caracteres
    System.out.println(palavra.getQuantidade('t'));
    System.out.println(palavra.getQuantidade('e'));
    System.out.println(palavra.getQuantidade('s'));
  
    // Posição Iezima Ocorrencia
    try {
      System.out.println(palavra.getPosicaoDaIezimaOcorrencia(0, 't'));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  
    try {
      System.out.println(palavra.getPosicaoDaIezimaOcorrencia(1, 't'));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  
    try {
      System.out.println(palavra.getPosicaoDaIezimaOcorrencia(2, 't'));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  
    // Tamanho
    System.out.println(palavra.getTamanho());
  
    // toString
    System.out.println(palavra);
  
    // equals
    Palavra testePalavra01 = null;
    Palavra testePalavra02 = null;
    Palavra testePalavra03 = null;
  
    try {
      testePalavra01 = new Palavra("teste");
    } catch (Exception e) {}
  
    try {
      testePalavra02 = new Palavra("erro");
    } catch (Exception e) {}
  
    try {
      testePalavra03 = new Palavra("testeDePalavra");
    } catch (Exception e) {}
  
    System.out.println(palavra.equals(testePalavra01));
    System.out.println(palavra.equals(testePalavra02));
    System.out.println(palavra.equals(testePalavra03));
  
    // hashCode
    System.out.println(palavra.hashCode());
  
    // compareTo
    System.out.println(palavra.compareTo(testePalavra01));
    System.out.println(palavra.compareTo(testePalavra02));
    System.out.println(palavra.compareTo(testePalavra03));
  }
}
