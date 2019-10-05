package Aula3;

public class Motociclo extends Veiculo{
	
	public Motociclo(int cilindrada, int potencia, int lotaçao, String carta, int pesoBruto) throws IllegalAccessException {
		super(cilindrada, potencia, lotaçao, carta, pesoBruto);		
	}
	
	public Motociclo(Motociclo l) throws IllegalAccessException{
		super(l.getCilindrada(),l.getPotencia(),l.getLotaçao(),l.getCartaNecessaria(),l.getPesoBruto());
		
	}

	@Override
	public String toString() {
		return "Motociclo :\n	Potencia: "+super.getPotencia()+"\n	Cilindrada: "+super.getCilindrada()+"\n	Peso Bruto:"+super.getPesoBruto();
	}
	
	public boolean canDrive(Condutor c) {
			return true;
	}

}
