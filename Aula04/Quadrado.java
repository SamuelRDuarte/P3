package Aula04;

public class Quadrado extends Rectangulo{
	
	public Quadrado(double l,Ponto c) {
		super(l,l,c);
	}
	
	public Quadrado(double x,double y,double l) {
		super(x,y,l,l);
	}
	
	public Quadrado(double l) {
		super(l,l,new Ponto(0,0));
	}
	
	public Quadrado(Quadrado q) {
		this(q.getLargura(),q.getCentro());
	}
	
	
	public double getPerimetro() {
		return super.getLargura()*4;
	}
	
	public String toString() {
		return "Quadrado com centro no ponto "+super.getCentro()+" e lado com "+super.getLargura()+"\n";
	}
	
	
	

}
