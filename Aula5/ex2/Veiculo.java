package Aula5.ex2;

public abstract class Veiculo implements Comparable<Veiculo> {
	
	private final int ano;
	private Cores corBase;
	private final int rodas;
	
	public Veiculo(int ano, Cores corBase, int rodas) {
		this.ano = ano;
		this.corBase = corBase;
		this.rodas = rodas;
	}
	
	public int getAno() {
		return ano;
	}
	public Cores getCorBase() {
		return corBase;
	}
	public int getRodas() {
		return rodas;
	}
	
	@Override
	public String toString() {
		return "Veiculo:"+"\n cor: "+ corBase +"\n Ano:"+ano+"\n rodas:"+rodas;
	}
	
	public int compareTo(Veiculo v) {
		if(v.getAno() == this.getAno()) return 0;
		if(this.getAno() < v.getAno()) return -1;
		return 1;
	}
	

}
