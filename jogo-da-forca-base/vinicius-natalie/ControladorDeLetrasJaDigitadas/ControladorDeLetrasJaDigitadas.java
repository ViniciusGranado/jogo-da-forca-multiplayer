// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package ControladorDeLetrasJaDigitadas;

public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo

        for (int i = 0; i < letrasJaDigitadas.length(); i++) {
            if (letrasJaDigitadas.charAt(i) == letra) {
                return true;
            }
        };

        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.

        if (this.isJaDigitada(letra)) throw new Exception("Letra ja registrada");

        this.letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).

        String retorno = "";

        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            if (i == letrasJaDigitadas.length() - 1) {
                retorno += this.letrasJaDigitadas.charAt(i);
                continue;
            };

            retorno += this.letrasJaDigitadas.charAt(i) + ",";
        }

        return retorno;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ControladorDeLetrasJaDigitadas controlador = (ControladorDeLetrasJaDigitadas) obj;

        return this.letrasJaDigitadas.equals(controlador.letrasJaDigitadas);
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this

        int hash = 123;

        hash = 13 * hash + new String(this.letrasJaDigitadas).hashCode();

        if (hash < 0) hash = -hash;

        return hash;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas

        if (controladorDeLetrasJaDigitadas == null) throw new Exception("Modelo ausente");

        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar

        ControladorDeLetrasJaDigitadas ret = null;

        try {
            ret = new ControladorDeLetrasJaDigitadas(this);
        } catch(Exception e) {}

        return ret;
    }
}
