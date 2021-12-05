// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package Tracinhos;

public class Testes {
  public static void main(String[] args) {
    // Testes classe Tracinhos
    System.out.println("\n-------------------");
    System.out.println("  CLASSE TRACINHOS ");
    System.out.println("-------------------\n");
    Tracinhos tracinhos = null;

    // Tracinhos invalidos
    try {
      tracinhos = new Tracinhos(-1);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    // Tracinhos validos
    try {
      tracinhos = new Tracinhos(5);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    // revele
    try {
      tracinhos.revele(-1, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      tracinhos.revele(5, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      tracinhos.revele(2, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    // isAindaComTracinhos
    System.out.println(tracinhos.isAindaComTracinhos());

    // Preencher com letras
    try {
      tracinhos.revele(0, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      tracinhos.revele(1, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      tracinhos.revele(3, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      tracinhos.revele(4, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println(tracinhos.isAindaComTracinhos());

    // toString
    System.out.println(tracinhos);

    // equals
    Tracinhos testeTracinhos01 = null;
    try {
      testeTracinhos01 = new Tracinhos(5);
    } catch (Exception e) {}

    System.out.println(tracinhos.equals(testeTracinhos01));

    // Preencher com letras
    try {
      testeTracinhos01.revele(0, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      testeTracinhos01.revele(1, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      testeTracinhos01.revele(2, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      testeTracinhos01.revele(3, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      testeTracinhos01.revele(4, 'a');
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    System.out.println(tracinhos.equals(testeTracinhos01));

    // hashCode
    System.out.println(tracinhos.hashCode());

    // clone
    Tracinhos copia = (Tracinhos) tracinhos.clone();
    System.out.println(copia);
    System.out.println(copia == tracinhos);
    System.out.println(copia.equals(tracinhos));
  }
}
