package Aula1;

public class Quadrado {
	
	private double lado;
	private Ponto centro;
	
public Quadrado(double l,Ponto c) {
		lado = l;
		centro = c;
	}
	
	public Quadrado(double x,double y,double l) {
		lado = l;
		centro = new Ponto(x,y);
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public double getAresta() {
		return lado;
	}
	
	public double getArea() {
		return lado*lado;
	}
	
	public double getPerimetro() {
		return lado*4;
	}
	
	public String toString() {
		return "Quadrado com centro no ponto "+centro.toString()+" e lado com "+lado+"\n";
	}
	
	public boolean igual(Quadrado a) {
		return lado == a.getAresta();
	}
	
	

}
