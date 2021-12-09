package forquinharede;

public class Forca
{
    public static void main (String args [])
    {
        
	   Palavra palavra =
	   BancoDePalavras.getPalavraSorteada();
			
	    Tracinhos tracinhos = null;
		try
		{
		   tracinhos = new Tracinhos (palavra.getTamanho());
        }
        catch (Exception erro) {}
            
            
	     ControladorDeLetrasJaDigitadas
		 controladorDeLetrasJaDigitadas =
		 new ControladorDeLetrasJaDigitadas ();
			

		while (tracinhos.isAindaComTracinhos() )
	    {
			
		   System.out.println ("------------------");
		   System.out.println (""+tracinhos);
		   System.out.println ("Digitadas.: "+controladorDeLetrasJaDigitadas);
		   System.out.println ("---------------------");
				
          try
			{
	
		      System.out.println("Se deseja digitar uma letra digite[l]"); 
		      System.out.print("Se deseja chutar a palavra  digite[p] ");
		      
		      char opçao = Character.toUpperCase (Teclado.getUmChar());
		     
		     
		     if(!(opçao=='L' || opçao=='P')) {
		    	 
		    	 System.out.println   ("opçao invalida ");
		     }
		     
		     
					 
			  if (opçao=='L'){
				  
				  
				    System.out.println   ("Qual letra? ");
				    System.out.println ();
					char letra = Character.toUpperCase (Teclado.getUmChar());
					 
					 if (controladorDeLetrasJaDigitadas.isJaDigitada (letra))
						System.err.println ("Essa letra ja foi digitada!\n");
					else
					{
						controladorDeLetrasJaDigitadas.registre (letra);

						int qtd = palavra.getQuantidade (letra); // por esse metodo verifica se tem a letra ou nao

						if (qtd==0)
						{
							System.err.println ("A palavra nao tem essa letra!\n");
							
						}
						else
						{
							for (int i=0; i<qtd; i++)
							{
								int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,letra);
								tracinhos.revele (posicao, letra);
							}
							System.out.println ();
						} } }
						
					      if(opçao=='P'){
					      
					      
					      
					  System.out.println   ("Qual a palavra? ");
					  Palavra Chute = new Palavra(Teclado.getUmString());
					  
					  if(Chute==palavra)
					   System.out.println   ("parabens voce acertou a palavra!! ");
					   //comunicado que ganhou
					   
					   else{
					    System.out.println   ("voce errou a palavra!! ");
					    
					   // o que vai desconectar a pessoa
					   
					   }
					
					
					
					}
				}
					  
					      
			  
				
					  
					  
				catch (Exception erro)
				{
					System.err.println (erro.getMessage());
				}
			}
			
    
			
			   if(!tracinhos.isAindaComTracinhos())
				System.out.println ("Parabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");
				//tambem podemos deixar oos comunicados aqui

				
    
    
    

			
    
    }
}
