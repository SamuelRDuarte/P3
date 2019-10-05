package Aula04;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String n,int c, Data d) {
		cc = c;
		nome = n;
		dataNasc = d;
	}
	
	public String nome() {
		return nome;
	}
	
	public int cc() {
		return cc;
	}
	
	public Data dataNasc() {
		return dataNasc;
	}
	
	public String toString() {
		return "cc="+cc+", nome="+nome+", dataNasc="+dataNasc;
	}
	
	public int compararNome(Pessoa paraComparar) {
		return (this.nome).compareTo(paraComparar.nome());
	}
	
	public int compararCC(Pessoa paraComparar) {
		if(paraComparar.cc<this.cc) return -1;
		if(paraComparar.cc ==this.cc) return 0;
		return 1;
	}
	
	

}
