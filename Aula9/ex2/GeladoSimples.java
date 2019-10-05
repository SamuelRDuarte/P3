package Aula9.ex2;

public class GeladoSimples implements Gelado {
	private String sabor;

	public GeladoSimples(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public void base(int n) {
		if(n>1)
			System.out.print("\n"+n+" bolas de gelado de "+sabor);
		else
			System.out.print("\n"+n+" bola de gelado de "+sabor);
	}

}
