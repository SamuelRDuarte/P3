package Aula5.ex2;

public class Moto extends Motorizado{
	
	public Moto(int ano, Cores corBase, int rodas, int cilindrada, int velocidadeMax, String matricula,
			Combustivel comb, double consumo, int potencia) {
		super(ano, corBase, rodas, cilindrada, velocidadeMax, matricula, comb, consumo, potencia);
		
	}

	@Override
	public String toString() {
		return "Moto [getMatricula()=" + getMatricula() + ", getAno()=" + getAno() + ", getCorBase()=" + getCorBase()
				+ "]";
	}
	
}
