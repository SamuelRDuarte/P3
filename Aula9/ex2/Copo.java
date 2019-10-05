package Aula9.ex2;

public class Copo extends GeladoDecorator {
	private String ingredient;

	public Copo(Gelado g, String ingredient) {
		super(g);
		this.ingredient = ingredient;
	}
	
	public Copo(Gelado g) {
		this(g,null);
	}
	
	public void base(int n) {
		g.base(n);
		if(ingredient == null)
			System.out.print(" em copo");
		else
			System.out.print(" em copo com "+ingredient);
	}

	

}
