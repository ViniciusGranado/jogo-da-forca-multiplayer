package jogodaforca;

public class ControladorDeErros implements Cloneable {
	
	private int qtdMax, qtdErr = 0;

	public ControladorDeErros(int qtdMax) throws Exception {
		if (qtdMax <= -1)
		throw new Exception("valor negativo");
		else
			this.qtdMax = qtdMax;
		
	}

	public void registreUmErro() throws Exception {
		if (this.qtdErr == this.qtdMax)
		throw new Exception("A quantidade maxima de erros foi atingida");

		else
			this.qtdErr++;
	}

	public boolean isAtingidoMaximoDeErros() {

		if (this.qtdErr == this.qtdMax) {return true;}

		else
			return false;
	}

	@Override
	public String toString() {
	return this.qtdErr + "/" + this.qtdMax;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)return true;
		if (obj == null)return false;

		if (obj.getClass() != ControladorDeErros.class)return false;
		
		ControladorDeErros x = (ControladorDeErros) obj;
		if (this.qtdMax != x.qtdMax)return false;
		if (this.qtdErr != x.qtdErr)return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		int ret = 1616;

		ret = 17 * +new Integer(this.qtdErr).hashCode();
		ret = 17 * +new Integer(this.qtdMax).hashCode();

		if (ret < 0)
			ret = -ret;
		return ret;

	}

	public ControladorDeErros(ControladorDeErros c) throws Exception // construtor de cópia
	{
		if (c == null) {
			throw new Exception(" erro nulo");
		}
		this.qtdErr = c.qtdErr;
		this.qtdMax = c.qtdMax;

	}

	@Override

	public Object clone() {
		ControladorDeErros 
		ret = null;
		try {
		ret = new ControladorDeErros(this);} 
		catch (Exception erro) {}
		return ret;

	}
}