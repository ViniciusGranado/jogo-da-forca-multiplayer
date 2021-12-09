package jogodaforca;

public class ControladorDeLetrasJaDigitadas implements Cloneable {
	private String letrasJaDigitadas;

	public ControladorDeLetrasJaDigitadas() {
		this.letrasJaDigitadas = "";
		
	}

	public boolean isJaDigitada(char letra) {

		// criei o indice para usar o lenfth

		for (int i = 0; i < letrasJaDigitadas.length(); i++) {
			if (letrasJaDigitadas.charAt(i) == letra)
				return true;
		}
		return false;
	}

	public void registre(char letra) throws Exception {

		if (this.isJaDigitada(letra)) {
			throw new Exception("a letra ja foi digitada");
		} else
			this.letrasJaDigitadas += letra;

	}

	@Override
	public String toString() {

		String x = "";

		for (char c : this.letrasJaDigitadas.toCharArray()) {
			x += c + ",";   
		}

		return x;

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj.getClass() != ControladorDeLetrasJaDigitadas.class)
			return false;
		ControladorDeLetrasJaDigitadas x = (ControladorDeLetrasJaDigitadas) obj;
		if (!this.letrasJaDigitadas.equals(x.letrasJaDigitadas))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int ret = 1616;

		if (this.letrasJaDigitadas != null)
			ret = 17 * ret + this.letrasJaDigitadas.hashCode();

		return ret;

	}

	public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
			throws Exception {
		if (controladorDeLetrasJaDigitadas == null) {
			throw new Exception("letra nula");
		}
		this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;

	}

	@Override
	public Object clone() {
		ControladorDeLetrasJaDigitadas ret = null;
		try {
			ret = new ControladorDeLetrasJaDigitadas(this);
		} catch (Exception erro) {
		}

		return ret;

	}
}