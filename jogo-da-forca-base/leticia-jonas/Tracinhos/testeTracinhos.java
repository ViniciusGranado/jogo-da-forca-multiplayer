package jogodaforca;


	
	public class TesteTracinhos {

		public static void main(String[] args) throws Exception{
			
		
			
			
			//teste 1
		    String traco = "Rodrigo";
			Tracinhos teste =  new Tracinhos(traco.length());
		    teste.revele(1, 'o');
		    System.out.println("testando se revela a letra"+teste);
		    System.out.println("");
		     
			//teste 2
			String traco1 = "Amanda";
			Tracinhos teste1 =  new Tracinhos(traco1.length());
			System.out.println(teste1+"Testando se esconde as letras");
			System.out.println("");
			
			//teste 3
			String traco2 = "c";
			Tracinhos teste2 =  new Tracinhos(traco2.length());
		    teste2.revele(0, 'c');
		    System.out.println("testando se revela a letra "+teste2);
		    System.out.println("");
			
			
			//teste 3
			System.out.println("");
			System.out.println("O teste3 ainda esta com tracinhos? "+teste2.isAindaComTracinhos());
			System.out.println("");
			//teste 3
			
			System.out.println("");
			System.out.println("O teste ainda esta com tracihos? "+teste.isAindaComTracinhos());
			System.out.println("");
			
			//teste 4
			System.out.println("E "+traco.equals(null)+" que \"TRACO \" eh igual (pelo equals) a \"NULL\"");
			System.out.println("");
			//teste 5
			System.out.println("E "+traco.equals(teste)+" que \"TRACO \" eh igual (pelo equals) a \"TESTE\"");
			System.out.println("");
			//teste 6
			System.out.println("E "+traco.equals(traco)+" que \"TRACO \" eh igual (pelo equals) a si mesmo");
			System.out.println("");
			//teste 7
			System.out.println("E "+teste.equals(null)+" que \"TESTE \" eh igual (pelo equals) a \"NULL\"");
			System.out.println("");
			//teste 8
			System.out.println("E "+teste.equals(teste)+" que \"TESTE\" eh igual (pelo equals) a si mesmo");
			System.out.println("");
			//teste 9
			System.out.println("E "+teste.equals(traco)+" que \"TESTE \" eh igual (pelo equals) a \"TRACO\"");
			System.out.println("");
			//teste 10
	        System.out.println ("Eh "+(teste.hashCode()==traco.hashCode())+" que o hashCode de \"TESTE\" eh igual ao hashCode de \"TRACO\"");
	        System.out.println("");
	        System.out.println(" Aqui estou testando o metodo clone"+teste.clone());
	        
	  
	      
	       
	        

	    }
	}

