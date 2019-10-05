package Aula1;

public class Ponto {
	
	private double x;
	private double y;
	
	public Ponto(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}
	
	public double distancia(Ponto a) {
		return Math.sqrt(Math.pow(this.x-a.x,2) + Math.pow(this.y-a.y, 2));
	}
	

}
