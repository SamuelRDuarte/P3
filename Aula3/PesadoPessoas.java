package Aula3;

public class PesadoPessoas extends Veiculo {
	
	public PesadoPessoas(int cilindrada, int potencia, int lotaçao, String carta, int pesoBruto) throws IllegalAccessException {
		super(cilindrada, potencia, lotaçao, carta, pesoBruto);
		if(carta.equals("A") || carta.equals("B") || carta.equals("C"))
				throw new IllegalAccessException("Carta Errada");
		
	}
	
	public PesadoPessoas(PesadoPessoas l) throws IllegalAccessException{
		super(l.getCilindrada(),l.getPotencia(),l.getLotaçao(),l.getCartaNecessaria(),l.getPesoBruto());
		
	}

	@Override
	public String toString() {
		return "Pesado de Pessoas :\n	Potencia: "+super.getPotencia()+"\n	Cilindrada: "+super.getCilindrada()+"\n	Peso Bruto:"+super.getPesoBruto();
	}
	
	public boolean canDrive(Condutor c) {
		if(c.getTipoCarta().equals("A") || c.getTipoCarta().equals("B") || c.getTipoCarta().equals("C"))
			return false;
		else
			return true;
	}

}
