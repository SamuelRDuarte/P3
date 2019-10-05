package Aula1;

public class Rectangulo {
	private double comprimento;
	private double largura;
	private Ponto centro;
	
	public Rectangulo(double com,double l,Ponto c) {
		centro = c;
		largura = l;
		comprimento = com;
	}
	
	public Rectangulo(double x,double y,double l,double c){
		largura = l;
		comprimento = c;
		centro = new Ponto(x,y);
	}
	
	public double getLargura() {
		return largura;
	}
	
	public double getComprimento() {
		return comprimento;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public double getArea() {
		return largura*comprimento;
	}
	
	public double getPerimetro() {
		return (2*largura)+(2*comprimento);
	}
	
	public String toString() {
		return "Rectangulo com centro no ponto "+centro.toString()+" comprimento de "+comprimento+" e de largura"+largura +"\n";
	}
	
	public boolean igual(Rectangulo a) {
		return (largura == a.getLargura()) && (comprimento == a.getComprimento());
	}

}
