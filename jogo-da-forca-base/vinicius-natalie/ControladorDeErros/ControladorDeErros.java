// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package ControladorDeErros;

public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		// verifica se qtdMax fornecida n�o � positiva, lan�ando
		// uma exce��o.
		// armazena qtdMax fornecida em this.qtdMax.

        if (qtdMax < 0) throw new Exception("Quantidade não permitida");

        this.qtdMax = qtdMax;
    }
    
    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou ent�o false, caso contrario.

        return this.qtdErr == this.qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja � igual a this.qtdMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo

        if (this.isAtingidoMaximoDeErros()) throw new Exception("Número máximo de erros atingidos");

        this.qtdErr++;
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ControladorDeErros controlador = (ControladorDeErros) obj;

        return (this.qtdErr == controlador.qtdErr &&
                this.qtdMax == controlador.qtdMax);
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int hash = 123;

        hash = 13 * hash + new Integer(this.qtdErr).hashCode();
        hash = 13 * hash + new Integer(this.qtdMax).hashCode();

        if (hash < 0) hash = -hash;

        return hash;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
        if (c == null) throw new Exception("Modelo ausente");

        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }

    public Object clone ()
    {
        // returnar uma c�pia de this
        ControladorDeErros ret = null;

        try {
            ret = new ControladorDeErros(this);
        } catch(Exception e) {}

        return ret;
    }
}
