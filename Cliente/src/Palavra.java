public class Palavra implements Comparable<Palavra>
{
  private String texto;

  public Palavra (String texto) throws Exception
  {
    if (texto == null || texto.length() == 0) {
      throw  new Exception("Palavra invalida!");
    };

    this.texto = texto;
  }

  public String getTexto() {
    return texto;
  }

  public int getQuantidade (char letra)
  {
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
    if (this == obj) return true;
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;

    Palavra palavra = (Palavra) obj;

    return this.texto.equals(palavra.texto);
  }

  public int hashCode ()
  {
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
