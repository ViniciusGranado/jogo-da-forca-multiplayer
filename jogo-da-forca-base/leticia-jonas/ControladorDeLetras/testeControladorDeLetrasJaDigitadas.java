package jogodaforca;

public class TesteControladorDeLetrasJaDigitadass {

	public static void main(String[] args) throws Exception {
		
		
	ControladorDeLetrasJaDigitadas letra= new ControladorDeLetrasJaDigitadas();
	letra.registre('g');
	letra.registre('a');
	letra.registre('b');
	System.out.println( "é "+letra.isJaDigitada('g')+" que  a letra digitada foi\"G\"");
	System.out.println( "é "+letra.isJaDigitada('h')+" que  a letra digitada foi\"h\"");
	System.out.println( "é "+letra.isJaDigitada('b')+" que  a letra digitada foi\"b\"");
	System.out.println( "é "+letra.isJaDigitada('j')+" que  a letra digitada foi\"j\"");
	System.out.println(" As letras que ja foram digitadas sao "+letra);
	System.out.println(" -----------------------------------");
	
	ControladorDeLetrasJaDigitadas letra1= new ControladorDeLetrasJaDigitadas();
	letra1.registre('l');
	letra1.registre('e');
	letra1.registre('t');
	System.out.println( "é "+letra.isJaDigitada('l')+" que  a letra digitada foi\"G\"");
	System.out.println( "é "+letra.isJaDigitada('e')+" que  a letra digitada foi\"h\"");
	System.out.println( "é "+letra.isJaDigitada('t')+" que  a letra digitada foi\"b\"");
	System.out.println(" As letras que ja foram digitadas sao "+letra1);
	System.out.println(" -----------------------------------");
	
	
	ControladorDeLetrasJaDigitadas letra2= new ControladorDeLetrasJaDigitadas();
	letra2.registre('l');
	letra2.registre('e');
	letra2.registre('t');
	System.out.println( "é "+letra.isJaDigitada('l')+" que  a letra digitada foi\"G\"");
	System.out.println( "é "+letra.isJaDigitada('e')+" que  a letra digitada foi\"h\"");
	System.out.println( "é "+letra.isJaDigitada('t')+" que  a letra digitada foi\"b\"");
	System.out.println(" As letras que ja foram digitadas sao "+letra2);
	System.out.println(" -----------------------------------");
	
	
	
	
	System.out.println("Testando equals ");
	System.out.println ("é "+letra1.equals(letra2)+" que \"letra1\" eh igual (pelo equals) a \"letra2\"");
	System.out.println ("é "+letra.equals(letra2)+" que \"letra\" eh igual (pelo equals) a  \"letra2\"");
	System.out.println ("é "+letra.equals(null)+" que \"letra\" eh igual (pelo equals) a  \"null\"");
	 System.out.println("---------------------------------------");
	
	
	 System.out.println("Testando hashcode ");
	 System.out.println ("é "+(letra1.hashCode()==letra2.hashCode())+" que o hashCode de um \"letra1\" eh igual ao hashCode de outro \"letra2\"");
	 System.out.println ("é "+(letra.hashCode()==letra1.hashCode())+" que o hashCode de um \"letra\" eh igual ao hashCode de outro \"letra1\"");
	 System.out.println("---------------------------------------");
	 
	 System.out.println("Testando clone");
	 System.out.println(letra1.clone());
	 System.out.println(letra.clone());
	 System.out.println(letra2.clone());
	 System.out.println("---------------------------------------");
	
	
	  
		
		
	}

}
