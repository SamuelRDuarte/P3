package Aula6.ex1;

public class PratoVegetariano extends Prato {

	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	@Override
	public boolean addIngrediente(Alimento a) {
		if(a == null) return false;
		if(a instanceof Vegetariano) {
			return super.addIngrediente(a);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vegetariano "+ super.toString();
	}
	
}
