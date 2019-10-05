package Aula9.ex2;

public class Cone extends GeladoDecorator {
	private String ingredient;

	public Cone(Gelado g, String ingredient) {
		super(g);
		this.ingredient = ingredient;
	}
	
	public Cone(Gelado g) {
		this(g,null);
	}
	
	public void base(int n) {
		g.base(n);
		if(ingredient == null)
			System.out.print(" em cone");
		else
			System.out.print(" em cone com "+ingredient);
	}

}
