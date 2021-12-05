// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package ControladorDeLetrasJaDigitadas;

public class Testes {
  public static void main(String[] args) {
    // Testes classe ControladorDeLetrasJaDigitadas
    System.out.println("\n----------------------------------------");
    System.out.println("   CLASSE ControladorDeLetrasJaDigitadas  ");
    System.out.println("----------------------------------------\n");

    ControladorDeLetrasJaDigitadas controladorLetras = new ControladorDeLetrasJaDigitadas();

    // registre
    try {
      controladorLetras.registre('a');
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      controladorLetras.registre('a');
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    
    // isJaDigitada
    try {
      System.out.println(controladorLetras.isJaDigitada('a'));
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    try {
      System.out.println(controladorLetras.isJaDigitada('e'));
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  
    // toString
    System.out.println(controladorLetras);
    
    // equals
    ControladorDeLetrasJaDigitadas testeControlador01 = new ControladorDeLetrasJaDigitadas();
    ControladorDeLetrasJaDigitadas testeControlador02 = new ControladorDeLetrasJaDigitadas();

    try {
      testeControlador01.registre('a');
    } catch(Exception e) {};

    try {
      testeControlador02.registre('e');
    } catch(Exception e) {};

    System.out.println(controladorLetras.equals(testeControlador01));
    System.out.println(controladorLetras.equals(testeControlador02));

    // hashCode
    System.out.println(controladorLetras.hashCode());

    // clone
    ControladorDeLetrasJaDigitadas clone = null;

    try {
      clone = (ControladorDeLetrasJaDigitadas) controladorLetras.clone();
    } catch (Exception e) {}

    System.out.println(controladorLetras == clone);
    System.out.println(controladorLetras.equals(clone));
  }
}
