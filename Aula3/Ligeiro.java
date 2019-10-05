package Aula3;

public class Ligeiro extends Veiculo {

	public Ligeiro(int cilindrada, int potencia, int lotaçao, String carta, int pesoBruto) throws IllegalAccessException {
		super(cilindrada, potencia, lotaçao, carta, pesoBruto);
		if(carta.equals("A"))
				throw new IllegalAccessException("Carta Errada");
		
	}
	
	public Ligeiro(Ligeiro l) throws IllegalAccessException{
		super(l.getCilindrada(),l.getPotencia(),l.getLotaçao(),l.getCartaNecessaria(),l.getPesoBruto());
		
	}

	@Override
	public String toString() {
		return "Veiculo Ligeiro :\n	Potencia: "+super.getPotencia()+"\n	Cilindrada: "+super.getCilindrada()+"\n	Peso Bruto:"+super.getPesoBruto();
	}
	
	public boolean canDrive(Condutor c) {
		if(c.getTipoCarta().equals("A"))
			return false;
		else
			return true;
	}
	
	
	

}
