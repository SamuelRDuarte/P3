package Aula3;

public class Veiculo {
	
	private int cilindrada;
	private int potencia;
	private int lotaçao;
	private String cartaNecessaria;
	private int PesoBruto;
	
	public Veiculo(int cilindrada, int potencia, int lotaçao, String carta, int pesoBruto) {
		
		if(!carta.equals("A") && !carta.equals("B") && !carta.equals("C") && !carta.equals("D"))
			throw new IllegalArgumentException("Carta invalida");
		
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.lotaçao = lotaçao;
		this.cartaNecessaria = carta;
		PesoBruto = pesoBruto;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getLotaçao() {
		return lotaçao;
	}

	public String getCartaNecessaria() {
		return cartaNecessaria;
	}

	public int getPesoBruto() {
		return PesoBruto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PesoBruto;
		result = prime * result + ((cartaNecessaria == null) ? 0 : cartaNecessaria.hashCode());
		result = prime * result + cilindrada;
		result = prime * result + lotaçao;
		result = prime * result + potencia;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (PesoBruto != other.PesoBruto)
			return false;
		if (cartaNecessaria == null) {
			if (other.cartaNecessaria != null)
				return false;
		} else if (!cartaNecessaria.equals(other.cartaNecessaria))
			return false;
		if (cilindrada != other.cilindrada)
			return false;
		if (lotaçao != other.lotaçao)
			return false;
		if (potencia != other.potencia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [cilindrada=" + cilindrada + ", potencia=" + potencia + ", lotaçao=" + lotaçao
				+ ", cartaNecessaria=" + cartaNecessaria + ", PesoBruto=" + PesoBruto + "]";
	}
	

}
