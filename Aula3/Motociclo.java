package Aula3;

public class Motociclo extends Veiculo{
	
	public Motociclo(int cilindrada, int potencia, int lota�ao, String carta, int pesoBruto) throws IllegalAccessException {
		super(cilindrada, potencia, lota�ao, carta, pesoBruto);		
	}
	
	public Motociclo(Motociclo l) throws IllegalAccessException{
		super(l.getCilindrada(),l.getPotencia(),l.getLota�ao(),l.getCartaNecessaria(),l.getPesoBruto());
		
	}

	@Override
	public String toString() {
		return "Motociclo :\n	Potencia: "+super.getPotencia()+"\n	Cilindrada: "+super.getCilindrada()+"\n	Peso Bruto:"+super.getPesoBruto();
	}
	
	public boolean canDrive(Condutor c) {
			return true;
	}

}
