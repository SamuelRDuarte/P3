package Aula6.ex2;

public class Circulo extends Figura {
	private double raio;
	
	public Circulo(double r) {
		super(new Ponto(0,0));
		raio = r;
	}
	
	public Circulo(double x,double y,double r) {
		super(x,y);
		raio = r;
	}
	
	public Circulo(Circulo c) {
		super(c.getCentro());
		raio = c.getRaio();
	}
	
	public double getRaio() {
		return raio;
	}
	
	public double getArea() {
		return Math.PI*Math.pow(raio, 2);
	}
	
	public double getPerimetro() {
		return 2*Math.PI*raio;
	}
	
	public String toString() {
		return "Circulo com centro no ponto "+super.getCentro()+" e raio com "+raio;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(raio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (raio != other.raio)
			return false;
		return true;
	}

	public boolean intersecao(Circulo a) {
		return super.getCentro().distancia(a.getCentro()) <=raio+a.getRaio();
	}
}
