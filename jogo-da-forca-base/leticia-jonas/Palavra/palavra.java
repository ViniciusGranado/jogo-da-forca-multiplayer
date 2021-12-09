package jogodaforca;

public class Palavra implements Comparable<Palavra>
{
    private String texto;
    public Palavra (String texto) throws Exception
    {
    	if(texto == null || texto.isEmpty())
	    	throw new Exception("Letra vazia ou nula");
	    	this.texto = texto;
    	
		
    }

    public int getQuantidade (char letra)
    {
    	int cont= 0;
    	for(char l: this.texto.toCharArray()) // metodo toCharArray esta transformando o THIS.TEXTO em vetor 
    	{
    	if (l == letra)
    		cont++; // Ele está percorrendo o char e está verificando se o char é igual a letra 
    	}
		return cont;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
    	int posi = -1;   
    	int cont = -1;
    	
    	for(char l: this.texto.toCharArray()) // metodo toCharArray esta transformando o THIS.TEXTO em vetor 
    	{
    	posi++; // O vetor ele começa pelo 0 = 1 primeira posição então ele sempre vai ver uma posição -1 por exemplo se eu 
    			// colocar 4 pra ver a posição da letra ELE VAI NA POSIÇÃO 3 POIS dentro do vetor ele é a 4 POSIÇÃO 
    		if (l== letra)
    		{
    			cont++;
    			if(cont==i)  // Ele está percorrendo o char e está verificando se o char é igual a letra 
    			{
    				return posi;	
    			}
    		}
    	}
		throw new Exception("Letra não encontrada");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }
@Override
    public boolean equals (Object obj)
    {
    	if (this == obj) return true;
    	if (obj == null) return false;
    	
    	if (obj.getClass() != Tracinhos.class) return false;
    	Palavra palavra = (Palavra)obj;
    	if(this.texto != palavra.texto) return false;
    	
    	return true;
    }
@Override
    public int hashCode ()
    {
    	 int ret=1616;
    	 
    	if(this.texto!=null) 
    		ret=17*ret+this.texto.hashCode();
    	
    	return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
