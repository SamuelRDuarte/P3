package ap2018;

public class Visitante {
	private static int id = 1;
	private int num;
	private String entrada;
	
	public Visitante( String entrada) {
		this.num = id++;
		this.entrada = entrada;
	}

	public int getNum() {
		return num;
	}

	public String getEntrada() {
		return entrada;
	}

	@Override
	public String toString() {
		return "Visitante [num=" + num + ", entrada=" + entrada + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + num;
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
		Visitante other = (Visitante) obj;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
}
