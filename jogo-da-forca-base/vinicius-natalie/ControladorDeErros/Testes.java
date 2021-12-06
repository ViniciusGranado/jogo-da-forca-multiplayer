// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package ControladorDeErros;

public class Testes {
  public static void main(String[] args) {
    // Testes classe ControladorDeErros
    System.out.println("\n------------------------------");
    System.out.println("   CLASSE ControladorDeErros  ");
    System.out.println("------------------------------\n");

    ControladorDeErros controladorErros = null;

    try {
      controladorErros = new ControladorDeErros(-1);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      controladorErros = new ControladorDeErros(2);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    // isAtingidoMaximoDeErros / registreUmErro
    System.out.println(controladorErros.isAtingidoMaximoDeErros());

    try {
      controladorErros.registreUmErro();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(controladorErros.isAtingidoMaximoDeErros());

    try {
      controladorErros.registreUmErro();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(controladorErros.isAtingidoMaximoDeErros());

    try {
      controladorErros.registreUmErro();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    // toString
    System.out.println(controladorErros);

    // equals
    ControladorDeErros testeControladorErros01 = null;
    ControladorDeErros testeControladorErros02 = null;

    try {
      testeControladorErros01 = new ControladorDeErros(2);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      testeControladorErros02 = new ControladorDeErros(2);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      testeControladorErros01.registreUmErro();
      testeControladorErros01.registreUmErro();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(controladorErros.equals(testeControladorErros01));
    System.out.println(controladorErros.equals(testeControladorErros02));

    // hashCode
    System.out.println(controladorErros.hashCode());

    // clone
    ControladorDeErros cloneControladorErros = null;
    try {
      cloneControladorErros = (ControladorDeErros) controladorErros.clone();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(controladorErros == cloneControladorErros);
    System.out.println(controladorErros.equals(cloneControladorErros));
  }
}
