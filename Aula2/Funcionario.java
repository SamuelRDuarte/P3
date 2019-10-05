package Aula2;

public class Funcionario extends Clientes {
	
	private int numFunc;
	private int nif;
	
	public Funcionario(int cC, String nome, Data dataNasc, int numFunc, int nIF,int n) {
		super(cC, nome, dataNasc,n);
		this.numFunc = numFunc;
		nif = nIF;
	}
	
	public int getNumFunc() {
		return numFunc;
	}
	public int getNIF() {
		return nif;
	}

	@Override
	public String toString() {
		return "Funcionario [numFunc=" + numFunc + ", nSocio=" + super.getnSocio() + ", Nome=" + super.getNome() + "]";
	}
	
	

}
