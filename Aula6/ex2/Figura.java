package Aula6.ex2;

public abstract class Figura {
	
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

}
