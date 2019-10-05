package Aula3;

public class Rectangulo extends Figura {
	private double comprimento;
	private double largura;
	
	public Rectangulo(double com,double l,Ponto c) {
		super(c);
		largura = l;
		comprimento = com;
	}
	
	public Rectangulo(double x,double y,double l,double c){
		super(x,y);
		largura = l;
		comprimento = c;
	}
	
	public Rectangulo(double comprimento, double largura) {
		super(new Ponto(0,0));
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public Rectangulo(Rectangulo r) {
		super(r.getCentro());
		largura = r.getLargura();
		comprimento = r.getComprimento();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(comprimento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(largura);
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
		Rectangulo other = (Rectangulo) obj;
		if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
			return false;
		if (Double.doubleToLongBits(largura) != Double.doubleToLongBits(other.largura))
			return false;
		return true;
	}

	public double getLargura() {
		return largura;
	}
	
	public double getComprimento() {
		return comprimento;
	}
	
	public double getArea() {
		return largura*comprimento;
	}
	
	public double getPerimetro() {
		return (2*largura)+(2*comprimento);
	}
	
	public String toString() {
		return "Rectangulo com centro no ponto "+super.getCentro()+" comprimento de "+comprimento+" e de largura"+largura +"\n";
	}
	
	

}
