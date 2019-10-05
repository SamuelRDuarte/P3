package Aula13.ex1;

public class Estadov2 extends Regiao {
	private Localidadev2<Cidade> capital;

	public Estadov2(String nome, int populacao, Localidadev2<Cidade> capital) {
		super(nome, populacao);
		this.capital = capital;
	}

	public Localidadev2<Cidade> getCapital() {
		return capital;
	}

}
