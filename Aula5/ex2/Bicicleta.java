package Aula5.ex2;

public class Bicicleta extends Veiculo{

	public Bicicleta(int ano, Cores corBase, int rodas) {
		super(ano, corBase, rodas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bicicleta [getAno()=" + getAno() + ", getCorBase()=" + getCorBase() + "]";
	}
	
}
