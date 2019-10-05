package Aula3;

public class Figura {
	
	private Ponto centro;
	
	public Figura(Ponto centro) {
		super();
		this.centro = centro;
	}
	
	public Figura(double x,double y) {
		centro = new Ponto(x,y);
	}

	public Ponto getCentro() {
		return centro;
	}

	@Override
	public String toString() {
		return "Figura tem centro no ponto " + centro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
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
		Figura other = (Figura) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		return true;
	}
	
	
	
	
	
	

}
