package Aula2;

public class Estudante extends Clientes {
	
	private int numMec;
	private String curso;
	
	public Estudante(int cC, String nome, Data dataNasc, int numMec, String curso,int n) {
		super(cC, nome, dataNasc,n);
		this.numMec = numMec;
		this.curso = curso;
	}
	
	public int getNumMec() {
		return numMec;
	}
	public String getCurso() {
		return curso;
	}

	@Override
	public String toString() {
		return "Estudante [numMec=" + numMec + ", curso=" + curso + ", nSocio=" + super.getnSocio() + ", getNome="
				+ super.getNome() + "]";
	}
	
	
	

}
