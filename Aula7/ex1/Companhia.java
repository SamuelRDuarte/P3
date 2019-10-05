package Aula7.ex1;

public class Companhia {
	private String sigla;
	private String companhia;
	
	public Companhia(String sigla, String companhia) {
		this.sigla = sigla;
		this.companhia = companhia;
	}

	public String getSigla() {
		return sigla;
	}

	public String getCompanhia() {
		return companhia;
	}

	@Override
	public String toString() {
		return companhia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Companhia other = (Companhia) obj;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}	
	
}
