package Aula5.ex2;

public class CarroPolicia extends Automovel implements Policia {
	private final Tipo t;
	private final String id;

	public CarroPolicia(int ano, Cores corBase, int rodas, int cilindrada, int velocidadeMax, String matricula,
			Combustivel comb, double consumo, int potencia, Tipo t, String id) {
		super(ano, corBase, rodas, cilindrada, velocidadeMax, matricula, comb, consumo, potencia);
		this.t = t;
		this.id = id;
	}

	@Override
	public Tipo getTipo() {
		return t;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String toString() {
		return "CarroPolicia [t=" + t + ", id=" + id + ", getAno()=" + getAno() + "]";
	}

	
	
}
