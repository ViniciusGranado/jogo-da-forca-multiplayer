// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package BancoDePalavras;
import Palavra.Palavra;


public class BancoDePalavras
{
    private static String[] palavras = 
    {
		"JAVA",
		"CLASSE",
		"OBJETO",
		"INSTANCIA",
		"PUBLICO",
		"PRIVATIVO",
		"METODO",
		"CONSTRUTOR",
		"SETTER",
		"GETTER",
		"LUZ",
		"PRAZER"
    };

    public static Palavra getPalavraSorteada ()
    {
        Palavra palavra = null;

        try
        {
            palavra =
            new Palavra (BancoDePalavras.palavras[
            (int)(Math.random() * BancoDePalavras.palavras.length)]);
        }
        catch (Exception e)
        {}

        return palavra;
    }
}
