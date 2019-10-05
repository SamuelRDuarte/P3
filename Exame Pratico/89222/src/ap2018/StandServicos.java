package ap2018;

public class StandServicos extends Stand {
	
	private Servico tipo;

	public StandServicos(String codigo, String nome, Participante resp, Servico tipo) {
		super(codigo, nome, resp);
		this.tipo = tipo;
	}

	public Servico getServico() {
		return tipo;
	}

	@Override
	public String toString() {
		return "StandServicos [tipo=" + tipo + "]"+"\n\t"+super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandServicos other = (StandServicos) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	public static Servico getServico(String s) {
		if(s.equals("Restaurante")) 
			return Servico.RESTAURANTE;
		if(s.equals("Cafetaria")) 
			return Servico.CAFETARIA;
		else 
			return Servico.MEETING;	
	}
}
