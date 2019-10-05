package ap2018;

public class StandOrganizacao extends Stand implements StandOrganizacao3{
	private String contato;
	
	public StandOrganizacao(String codigo, String nome, Participante resp,String contato) {
		super(codigo, nome, resp);
		this.contato =contato;
	}

	public static StandOrganizacao instance(String string, String string2, Participante participante, String string3) {
		return new StandOrganizacao(string,string2,participante,string3);
	}

	public String getContato() {
		return contato;
	}

	@Override
	public String toString() {
		return "StandOrganizacao2 [contato=" + contato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
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
		StandOrganizacao other = (StandOrganizacao) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		return true;
	}
	
	
}
