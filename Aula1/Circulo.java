package Aula1;



public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(double r,Ponto c) {
		raio = r;
		centro = c;
	}
	
	public Circulo(double x,double y,double r) {
		raio = r;
		centro = new Ponto(x,y);
	}
	
	public double getRaio() {
		return raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public double getArea() {
		return Math.PI*raio*raio;
	}
	
	public double getPerimtro() {
		return Math.PI*2*raio;
	}
	
	public String toString() {
		return "Circulo com centro no ponto "+centro.toString()+" e raio com "+raio+"\n";
	}
	
	public boolean iguais(Circulo a) {
		return this.raio == a.getRaio();
	}
	
	public boolean intersecao(Circulo a) {
		return centro.distancia(a.getCentro()) <=raio+a.getRaio();
	}
}
