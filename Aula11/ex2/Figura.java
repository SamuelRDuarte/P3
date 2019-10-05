package Aula11.ex2;

public abstract class Figura implements Comparable<Figura>{
	
	private Ponto centro;
	
	public Figura(Ponto centro) {
		this.centro = centro;
	}
	
	public Figura(double x,double y) {
		centro = new Ponto(x,y);
	}

	public Ponto getCentro() {
		return centro;
	}
	
	public abstract double getArea();
	public abstract double getPerimetro();
	
	public int compareTo(Figura f) {
		if(f.getArea() == this.getArea()) return 0;
		if(this.getArea() < f.getArea()) return -1;
		return 1;
	}

}
