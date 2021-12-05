// Alunos
// Natalie Gomes de Moraes 21109
// Vinicius Rafael Granado 21731

package Palavra;

public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido � nulo ou ent�o vazio,
		// ou seja, sem nenhum caractere, lan�ando exce��o.
		// armazena o texto recebido em this.texto.

        if (texto == null || texto.length() == 0) {
            throw  new Exception("Palavra invalida!");
        };

        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida

        int contador = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == letra) {
                contador++;
            }
        }

        return contador;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lan�ar excecao caso nao encontre em this.texto
        // a I�zima apari��o da letra fornecida.

        int contador = 0;

        for (int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                if (contador == i) {
                    return j;
                }

                contador++;
            }
        }

        throw new Exception("Posição não encontrada");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Palavra palavra = (Palavra) obj;

        return this.texto.equals(palavra.texto);
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int hash = 123;

        hash = 13 * hash + new String(this.texto).hashCode();

        if (hash < 0) hash = -hash;

        return hash;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
