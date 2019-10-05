package Aula3;

public class PesadoMercadorias extends Veiculo{
	
	public PesadoMercadorias(int cilindrada, int potencia, int lotaçao, String carta, int pesoBruto) throws IllegalAccessException {
		super(cilindrada, potencia, lotaçao, carta, pesoBruto);
		if(carta.equals("A") || carta.equals("B"))
				throw new IllegalAccessException("Carta Errada");
		
	}
	
	public PesadoMercadorias(PesadoMercadorias l) throws IllegalAccessException{
		super(l.getCilindrada(),l.getPotencia(),l.getLotaçao(),l.getCartaNecessaria(),l.getPesoBruto());
		
	}

	@Override
	public String toString() {
		return "Pesado de Mercadorias :\n	Potencia: "+super.getPotencia()+"\n	Cilindrada: "+super.getCilindrada()+"\n	Peso Bruto:"+super.getPesoBruto();
	}
	
	public boolean canDrive(Condutor c) {
		if(c.getTipoCarta().equals("A") || c.getTipoCarta().equals("B"))
			return false;
		else
			return true;
	}

}
