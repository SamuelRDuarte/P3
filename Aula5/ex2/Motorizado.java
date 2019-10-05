package Aula5.ex2;

public abstract class Motorizado extends Veiculo{
	private final int cilindrada;
	private final int velocidadeMax;
	private final String Matricula;
	private final Combustivel comb;
	private final double consumo;
	private final int potencia;
	
	public Motorizado(int ano, Cores corBase, int rodas, int cilindrada, int velocidadeMax, String matricula,
			Combustivel comb, double consumo, int potencia) {
		super(ano, corBase, rodas);
		this.cilindrada = cilindrada;
		this.velocidadeMax = velocidadeMax;
		Matricula = matricula;
		this.comb = comb;
		this.consumo = consumo;
		this.potencia = potencia;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public int getVelocidadeMax() {
		return velocidadeMax;
	}

	public String getMatricula() {
		return Matricula;
	}

	public Combustivel getCombustivel() {
		return comb;
	}

	public double getConsumo() {
		return consumo;
	}

	public int getPotencia() {
		return potencia;
	}
	
	
	 
}
