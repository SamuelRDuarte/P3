package Aula7.ex1;

public class Voo implements Comparable<Voo>{
	private Hora tempo;
	private String voo;
	private Companhia companhia;
	private String origem;
	private Hora atraso;
	
	public Voo(Hora tempo, String voo, Companhia companhia, String origem, Hora atraso) {
		if(tempo == null||voo == null||companhia==null||origem ==null) throw new NullPointerException("Pelo menos um atributo está vazio");
		this.tempo = tempo;
		this.voo = voo;
		this.companhia = companhia;
		this.origem = origem;
		this.atraso = atraso;
	}

	public Hora getTempo() {
		return tempo;
	}

	public String getVoo() {
		return voo;
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public String getOrigem() {
		return origem;
	}

	public Hora getAtraso() {
		return atraso;
	}
	
	public int atrasoMinutos() {
		return atraso.getTotalMinutos();
	}

	@Override
	public String toString() {
		String obs = "Previsto: "+Hora.horaPrevista(tempo, atraso).toString();
		return String.format("%s\t%-10s\t%-18s\t%-20s\t%-5s\t%s",tempo.toString(),voo,companhia.toString(),origem,atraso.toString(),obs);
	}
	
	public int compareTo(Voo a) {
		return this.atrasoMinutos()-a.atrasoMinutos();
	}
	
	
}
