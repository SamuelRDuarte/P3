package Aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia {
	private final Tipo t;
	private final String id;
	
	public BicicletaPolicia(int ano, Cores corBase, int rodas, Tipo t, String id) {
		super(ano, corBase, rodas);
		this.t = t;
		this.id = id;
	}

	@Override
	public Tipo getTipo() {
		return t;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String toString() {
		return "BicicletaPolicia [t=" + t + ", id=" + id + ", getAno()=" + getAno() + "]";
	}
	
}
