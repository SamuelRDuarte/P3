package Aula3.ex4;

public class Funcionario extends Utilizador {
	private int numFiscal,numFuncionario;

	public Funcionario(String nome,int numFiscal, int cc, int numFuncionario, Data dateNasc) {
		super(nome, cc, dateNasc);
		this.numFiscal = numFiscal;
		this.numFuncionario = numFuncionario;
	}

	public int getNumFiscal() {
		return numFiscal;
	}

	public int getNumFuncionario() {
		return numFuncionario;
	}
	
}
