package Aula6.ex1;

public enum DiaSemana {
	segunda(0),terca(1),quarta(2),quinta(3),sexta(4),sabado(5),domingo(6);
	
	private int i;

	private DiaSemana(int i) {
		this.i = i;
	}
	
	
	
	public int getDia() {
		return i;
	}

	public static DiaSemana enumDia(int n) {
		DiaSemana d = null;
		for(DiaSemana a: values()) {
			if(a.getDia() == n) return a;
		}
		return d;
	}
	
	public static DiaSemana rand() {
		int d = (int) (Math.random()*6);
		DiaSemana dia = null; 
		for(DiaSemana a: values()) {
			if(a.getDia()==d) dia=a;
		}
		return dia;
	}

}
