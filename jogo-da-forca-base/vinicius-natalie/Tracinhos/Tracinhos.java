// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package Tracinhos;

import java.util.Arrays;

public class Tracinhos implements Cloneable
{
    private char[] texto;

    public Tracinhos (int qtd) throws Exception
    {
		// verifica se qtd n�o � positiva, lan�ando uma exce��o.
		// instancia this.texto com um vetor com tamanho igual qtd.
		// preenche this.texto com underlines (_).

        if (qtd <= 0) throw new Exception("Quantidade invalida");

        this.texto = new char[qtd];
        Arrays.fill(this.texto, '_');
    }

    public void revele (int posicao, char letra) throws Exception
    {
        // verifica se posicao � negativa ou ent�o igual ou maior
        // do que this.texto.length, lan�ando uma exce��o.
        // armazena a letra fornecida na posicao tambem fornecida
        // do vetor this.texto

        if (posicao < 0 || posicao >= this.texto.length) {
            throw new Exception("Posicao invalida");
        }

        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] == '_') return true;
        };

        return false;
    }

    public String toString ()
    {
        // retorna um String com TODOS os caracteres que h�
        // no vetor this.texto, intercalados com espa�os em
        // branco

        String retorno = "";

        for (int i = 0; i < this.texto.length; i++) {
            if (i == this.texto.length - 1) {
                retorno += this.texto[i];
                continue;
            }

            retorno += this.texto[i] + " ";
        }

        return retorno;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Tracinhos tracinhos = (Tracinhos) obj;

        return Arrays.equals(this.texto, tracinhos.texto);
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this

        int hash = 1;

        if (this.texto != null) {
            hash = 13 * hash + this.texto.hashCode();
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conte�do de t.texto para this.texto

        if (t == null) throw new Exception("Modelo ausente");

        this.texto = new char[t.texto.length];

        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        };
    }

    public Object clone ()
    {
        // retornar uma copia de this
        Tracinhos ret = null;

        try {
            ret = new Tracinhos(this);
        } catch(Exception e) {};

        return ret;
    }
}
