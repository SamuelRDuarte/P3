package Aula13.ex1;

public abstract class Regiao {
	private String nome;
	private int populacao;
	
	public Regiao(String nome, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
	}

	public String getNome() {
		return nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	@Override
	public String toString() {
		return "Regiao [nome=" + nome + ", populacao=" + populacao + "]";
	}
	
}
