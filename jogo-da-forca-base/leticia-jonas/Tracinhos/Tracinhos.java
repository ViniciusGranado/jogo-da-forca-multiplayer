package jogodaforca;

public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
    	if(qtd <= 0) 
    	{
    		throw new Exception("Quantidade negativa");
    	}
    	
    	this.texto = new char[qtd];
    	
    	for(int i = 0; i < qtd; i++) 
    	{
    		this.texto[i] = '_';
    	}
    }
    public void revele (int posicao, char letra) throws Exception
    {
    	if(posicao < 0 || posicao >= this.texto.length) {
    		throw new Exception("Posição negativa");
    	}
    	this.texto[posicao] = letra;
    }

    
    

    public boolean isAindaComTracinhos ()
    {
    	
    for(int i = 0; i <this.texto.length; i++) {
    	    		if(this.texto[i] == '_') {
    	    			return true;
    	    		}    		
    	    	}
    	    	return false;
       
    }

    public String toString ()
    {
    	String ret = "";
    	for(int i = 0; i< this.texto.length; i++) {
    		System.out.print(texto[i]+" ");
    	}
    	return ret;
    }

    public boolean equals (Object obj)
    {
    	if (this == obj) return true;
    	if (obj == null) return false;
    	
    	if (obj.getClass() != Tracinhos.class) return false;
    	Tracinhos tracinho = (Tracinhos)obj;
    	if(this.texto != tracinho.texto) return false;
    	
    	return true;	
    }
@Override
    public int hashCode ()
    {
	  int  ret=2525;
	   ret=17*ret +(this.texto).hashCode();
	   
	   if(ret<0)ret=-ret;
	   return ret;
    	
        // calcular e retornar o hashcode de this
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de cópia
    {
    	this.texto = new char[t.texto.length];
    	this.texto = t.texto;
    }

    public Object clone ()
    {
       Tracinhos ret= null;
       try {
    	   ret=new Tracinhos(this);
       }
       catch(Exception erro) {}
       return ret;
       
       
    }
}
