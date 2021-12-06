package jogodaforca;

public class TestePalavra{
	
	

	public static void main (String[] args)
    {
        // teste 1
		try
		{
			Palavra p = new Palavra (null);
		    System.out.println (p);
		}
		catch (Exception erro) {
			System.err.println("Deu erro");
		}
			
		System.out.println("");
	        
	//teste2	
		try
		{
			  Palavra p = new Palavra ("jonas");
		      System.out.println (p);
		}
		catch (Exception erro) {
			System.err.println("Deu erro");
		}
			
		System.out.println("");
	   //teste 3
		
		try
		{
			  Palavra p = new Palavra ("");
		      System.out.println (p);
		}
		catch (Exception erro) {
			System.err.println("Deu erro");
		}
			
		System.out.println("");
	        
		
        //teste 2
		try 
		{
			Palavra p1 = new Palavra ("JONAS");
			System.out.println ("Qual a quantidade de \"J\" que temos no nome JONAS? "+p1.getQuantidade('J')+"  \" e para ter 1\"");
		}
		catch (Exception erro)
		{
			System.err.println("Não pode dar erro");
		}
        //teste 3
        try
        {
        Palavra p2 = new Palavra("ALEMANHA");
        System.out.println("Qual a quantidade de \"A\" que temos no nome ALEMANHA? "+p2.getQuantidade('A')+"  \" e para ter 3\"");
        }
        catch (Exception erro) 
        {
        	System.err.println("Não pode dar erro");
        }
        
        
        
        
        
        
        //teste 4
        System.out.println("");
       
        try
        {  Palavra p3 = new Palavra("ALEMANHA");
            System.out.println ("A 0 letra 'E' de \"ALEMANHA\" fica na posicao " + p3.getPosicaoDaIezimaOcorrencia(-1,'E'));
           
            System.err.println ("Achamos a 0 aparicao da letra 'E' em \"ALEMANHA\" não é para achar");
        }
        catch (Exception erro)
        {
            System.out.println ("Deu erro ao achar a 0 aparicao da letra 'E' em \"ALEMANHA\" é para dar erro");
        }
        //teste 5
        try
        {
        	Palavra p4 = new Palavra("JONAS");
        	System.out.println("A 0 letra 'A' \"JONAS\" fica na posicao "+p4.getPosicaoDaIezimaOcorrencia(-1, 'A'));
        	
        	System.err.println("Achamos a 0 aparicao da letra 'A' em \"JONAS\" não é para achar");
        }
        catch(Exception erro) 
        {
        	System.out.println ("Deu erro ao achar a 0 aparicao da letra 'A' em \"JONAS\" é para dar erro");
        }
        System.out.println("");
      //teste 6
        try 
        {   Palavra p5 = new Palavra("JONAS");
        	System.out.println("A UNICA letra 'A' de \"JONAS\" fica na posicao "+p5.getPosicaoDaIezimaOcorrencia(0, 'A'));
        }
        catch(Exception erro) 
        {
        	System.err.println ("Deu erro ao achar a UNICA aparicao da letra 'A' em \"JONAS\"");
        }
      //teste 7
        try 
        {   Palavra p6 = new Palavra("ALEMANHA");
        	System.out.println("A UNICA letra 'M' de \"ALEMANHA\" fica na posicao "+p6.getPosicaoDaIezimaOcorrencia(0, 'M'));
        }
        catch(Exception erro) 
        {
        	System.err.println ("Deu erro ao achar a UNICA aparicao da letra 'M' em \"ALEMANHA\"");
        }
        System.out.println("");
        //teste 8
        try
        {
        	Palavra p7 = new Palavra("COMPUTADOR");
        	Palavra p8 = new Palavra("TELEVISOR");
        	
        	System.out.println("A palavra \"COMPUTADOR\" tem "+p7.getQuantidade('R')+" \"R\" e a sua unica aparicao fica na posicao "+
        	p7.getPosicaoDaIezimaOcorrencia(0, 'R'));
        	System.out.println("A palavra \"TELEVISOR\" tem "+p8.getQuantidade('E')+" \"E\" e a sua primeira aparicao fica na posicao "+
            p8.getPosicaoDaIezimaOcorrencia(0, 'E'));
        	
        }
        catch(Exception erro)
        {
        	System.err.println("Deu erro");
        }
         
        
        
        
        
        
        
        
        String vetorteste[] = {"Posicao 0"," Posicao 1","Posicao 2","Posicao 3","Posicao 4"};
          System.out.println("");
        
        // teste 9
        System.out.println ("E "+vetorteste[0].equals(null)+" que \"Posicao 0 \" eh igual (pelo equals) a null");
        System.out.println("");
        System.out.println ("E "+vetorteste[1].equals(vetorteste[1])+" que \"Posicao 1\" eh igual (pelo equals) a si mesmo");
        System.out.println("");
        System.out.println ("E "+vetorteste[0].equals("Não nulo")+" que \"Posicao 0\" eh igual (pelo equals) ao String \"Posicao 0\"");
        System.out.println("");
        System.out.println ("E "+vetorteste[0].equals(vetorteste[2])+" que \"Posicao 0\" eh igual (pelo equals) a \"Posicao 0\"ESTÁ COMPARANDO POSICAO 0 COM A 2");
        System.out.println("");
        
        System.out.println ("Eh "+vetorteste[0].equals(vetorteste[3])+" que \"Posicao 0\" eh igual (pelo equals) a \"Posicao 3\"");
        
        System.out.println("");
        // teste 10
        System.out.println ("Eh "+(+vetorteste[0].hashCode()==vetorteste[3].hashCode())+" que o hashCode de um \"Posicao 0\" eh igual ao hashCode de outro \"Posicao 3\"");
        System.out.println("");
        System.out.println ("Eh "+(vetorteste[0].hashCode()==vetorteste[4].hashCode())+" que o hashCode de \"Posicao 0\" eh igual ao hashCode de \"Posicao 4\"");
        System.out.println("");
        System.out.println ("Eh "+(vetorteste[0].hashCode()==vetorteste[0].hashCode())+" que o hashCode de \"Posicao 0\" eh igual ao hashCode de \"Posicao 0\"");
        
     
    }   
}
