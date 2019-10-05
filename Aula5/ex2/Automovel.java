package Aula5.ex2;

public class Automovel extends Motorizado{	
	
	public Automovel(int ano, Cores corBase, int rodas, int cilindrada, int velocidadeMax, String matricula,
			Combustivel comb, double consumo, int potencia) {
		super(ano, corBase, rodas, cilindrada, velocidadeMax, matricula, comb, consumo, potencia);
		
	}

	@Override
	public String toString() {
		return "Automovel [getMatricula()=" + getMatricula() + ", getAno()=" + getAno() + ", getCorBase()="
				+ getCorBase() + "]";
	}
	
}
