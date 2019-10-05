package ap2018;

import java.util.*;

public class StandEmpresa extends Stand{
	private List<Participante> lista;
	

	public StandEmpresa(String codigo, String nome, Participante resp) {
		super(codigo, nome, resp);
		this.lista = new ArrayList<>();
		lista.add(resp);
	}

	public StandEmpresa(String codigo, String nome, Participante responsavel,  List<Participante> lista) {
		super(codigo, nome,responsavel);
		this.lista = lista;
	}

	public List<Participante> membros() {
		return lista;
	}
	
	public void add(Participante p) {
		lista.add(p);
	}

	@Override
	public String toString() {
		return "StandEmpresa [lista=" + lista + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		StandEmpresa other = (StandEmpresa) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}
	
	
}
