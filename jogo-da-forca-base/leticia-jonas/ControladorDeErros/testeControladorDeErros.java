package jogodaforca;

public class TesteControladorDeErros {

	public static void main(String[] args) throws Exception {
		
		
		
		       System.out.println("testando se ele mostra quando a quantidade maxima de erros é atingida, e registrando um erro");
		       System.out.println("a quantidade maxima de erros é 1");
		        ControladorDeErros  erros1= new ControladorDeErros(1);
				erros1.registreUmErro();
				System.out.println("registrei um erro");
				System.out.println(erros1);
				if(erros1.isAtingidoMaximoDeErros()==true) {
				System.out.println("contidade maxima se erros atingidos");}
				System.out.println("---------------------------------------");
				
		
				System.out.println("testando se quando a quantidade maxima de erros nao é atingida ele passa ");
				System.out.println("a quantidade maxima de erros é 5");
		        ControladorDeErros  erros2= new ControladorDeErros(5);
		        erros2.registreUmErro();
		        System.out.println("registrei um erro");
		        erros2.registreUmErro();
		        System.out.println("registrei um erro");
		        if(erros2.isAtingidoMaximoDeErros()==true) {
					System.out.println("contidade maxima se erros atingidos");}
				System.out.println(erros2);
				System.out.println("---------------------------------------");

				
				System.out.println("a quantidade maxima de erros é 5");
		        ControladorDeErros  erros3= new ControladorDeErros(5);
		        erros3.registreUmErro();
		        System.out.println("registrei um erro");
		        erros3.registreUmErro();
		        System.out.println("registrei um erro");
		        if(erros2.isAtingidoMaximoDeErros()==true) {
					System.out.println("contidade maxima se erros atingidos");}
				System.out.println(erros3);
				System.out.println("---------------------------------------");
				
				
				System.out.println("Testando equals ");
				System.out.println ("é "+erros2.equals(erros3)+" que \"erros2\" eh igual (pelo equals) a \"erros3\"");
				System.out.println ("é "+erros3.equals(erros1)+" que \"erros3\" eh igual (pelo equals) a  \"erros1\"");
				System.out.println ("é "+erros3.equals(null)+" que \"erros3\" eh igual (pelo equals) a  \"null\"");
				System.out.println("---------------------------------------");
				
				
				 System.out.println("Testando hashcode ");
				 System.out.println ("é "+(erros3.hashCode()==erros2.hashCode())+" que o hashCode de um \"erros2\" eh igual ao hashCode de outro \"erros3\"");
				 System.out.println ("é "+(erros3.hashCode()==erros1.hashCode())+" que o hashCode de um \"erros2\" eh igual ao hashCode de outro \"erros1\"");
				 System.out.println("---------------------------------------");
				 
				 
				 System.out.println("Testando clone");
				 System.out.println(erros1.clone());
				 System.out.println(erros2.clone());
				 System.out.println(erros3.clone());
				 System.out.println("---------------------------------------");
				 
				 
				System.out.println("Testando se quando o valor negativo é passado ocorre erro");
				System.out.println("a quantidade maxima de erros é -2");
		        ControladorDeErros  erros4= new ControladorDeErros(-2);
		        erros4.registreUmErro();
		        System.out.println("---------------------------------------");
		        
		       
		        
		       

	}

}