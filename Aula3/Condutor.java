package Aula3;

public class Condutor extends Pessoa {
	
	private String tipoCarta;

	public Condutor(String n, int c, Data d, String carta) {
		super(n, c, d);
		
		if(!carta.equals("A") && !carta.equals("B") && !carta.equals("C") && !carta.equals("D"))
			throw new IllegalArgumentException("Carta invalida");
		
		this.tipoCarta = carta;
	}
	
	public Condutor(String carta,Pessoa p) {
		this(p.nome(),p.cc(),p.dataNasc(),carta);
	}
	
	public Condutor(Condutor c) {
		this(c.nome(),c.cc(),c.dataNasc(),c.getTipoCarta());
	}

	public String getTipoCarta() {
		return tipoCarta;
	}

	@Override
	public String toString() {
		return "Condutor: "+ super.nome()+", Carta: " + tipoCarta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoCarta == null) ? 0 : tipoCarta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condutor other = (Condutor) obj;
		if (tipoCarta == null) {
			if (other.tipoCarta != null)
				return false;
		} else if (!tipoCarta.equals(other.tipoCarta))
			return false;
		return true;
	}
	
	
	
	
	
	

}
