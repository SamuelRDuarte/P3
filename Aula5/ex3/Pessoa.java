package Aula5.ex3;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	private int contacto;
	
	public Pessoa(String n,int c, Data d,int cont) {
		cc = c;
		nome = n;
		dataNasc = d;
		contacto = cont;
	}
	
	public Pessoa(String nome, Data dataNasc, int contacto) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.contacto = contacto;
	}

	public Pessoa(String nome, int cc, Data dataNasc) {
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
	}

	public int contacto() {
		return contacto;
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
	
	@Override
	public String toString() {
		return nome+", BI: "+cc+", Data: "+dataNasc+", Contacto: "+contacto;
	}
	
	public String toString(String s) {
		return nome +s+contacto+s+dataNasc;
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
