package Aula7.ex1;

public class Hora {
	private int totalminutos;
	
	public Hora(int minutos) {
		totalminutos = minutos;
	}
	
	public Hora(int hora,int minutos) {
		this(hora*60+minutos);
	}
	
	public Hora(String s,String div) {
		this(Integer.parseInt(s.split(div)[0]),Integer.parseInt(s.split(div)[1]));
	}
	
	public Hora(String s) {
		this(s,":");
	}
	
	public Hora() {
		this(0);
	}
	
	public int getTotalMinutos() {
		return totalminutos;
	}

	public int getHoras() {
		return totalminutos/60;
	}
	public int getMinutos() {
		return totalminutos%60;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d",this.getHoras(),this.getMinutos());
	}
	
	public static Hora horaPrevista(Hora i,Hora e) {
		int somaminutos = i.getTotalMinutos()+e.getTotalMinutos();
		int h = somaminutos/60;
		int m = somaminutos%60;
		if(h>23) h = h-24;
		return new Hora(h,m);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + totalminutos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hora other = (Hora) obj;
		if (totalminutos != other.totalminutos)
			return false;
		return true;
	}
	
}
