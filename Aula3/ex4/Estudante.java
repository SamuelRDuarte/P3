package Aula3.ex4;

public class Estudante extends Utilizador {
	private int nmec;
	private String curso;
	public Estudante(String nome, String curso, int cc, int nmec, Data dateNasc) {
		super(nome, cc, dateNasc);
		this.nmec = nmec;
		this.curso = curso;
	}
	public int getNmec() {
		return nmec;
	}
	public String getCurso() {
		return curso;
	}
	
}
