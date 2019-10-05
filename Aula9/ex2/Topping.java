package Aula9.ex2;

public class Topping extends GeladoDecorator {
	private String ingredient;

	public Topping(Gelado g, String ingredient) {
		super(g);
		this.ingredient = ingredient;
	}
	
	public void base(int n) {
		g.base(n);
		System.out.print(" com "+ingredient);
	}

}
