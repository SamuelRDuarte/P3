package Aula04;

import java.util.ArrayList;

public class ColecaoFiguras {
	private final double maxArea;
	private double currentArea;
	private ArrayList<Figura> figuras = new ArrayList<>();
	
	public ColecaoFiguras(double maxArea) {
		this.maxArea = maxArea;
		this.currentArea = 0;
	}

	public double areaTotal() {
		return currentArea;
	}
	
	public boolean exists(Figura f) {
		return figuras.contains(f);
	}
	
	public boolean addFigura(Figura f) {
		if(currentArea+f.getArea()>maxArea || figuras.contains(f)) {
			return false;
		}
		
		figuras.add(f);
		currentArea += f.getArea();
		return true;
	}
	
	public boolean delFigura(Figura f) {
		currentArea -= f.getArea();
		return figuras.remove(f);
	}
	
	public String toString(){
		return "Area maxima: "+maxArea+"\nNumero de figuras: "+figuras.size();
	}
	
	public Figura[] getFiguras() {
		return figuras.toArray(new Figura[0]);
	}
	
	public Ponto[] getCentros() {
		ArrayList<Ponto> centros = new ArrayList<>();
		for(Figura f: getFiguras()) {
			centros.add(f.getCentro());
		}
		return centros.toArray(new Ponto[0]);
	}
	
	
	

}
