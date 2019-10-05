package Aula13.ex1;

public class Estado extends Regiao {
	private Localidade capital;

	public Estado(String nome, int populacao, Localidade capital) {
		super(nome, populacao);
		if(capital.getTipo() != TipoLocalidade.Cidade)
			throw new IllegalArgumentException("Capital de um pais tem de ser uma cidade");
		this.capital = capital;
	}

	public Localidade getCapital() {
		return capital;
	}

}
