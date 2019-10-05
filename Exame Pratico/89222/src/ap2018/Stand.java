package ap2018;

public class Stand implements Expositor{
	private String codigo;
	private String nome;
	private Participante resp;
	

	public Stand(String codigo, String nome, Participante resp) {
		this.codigo = codigo;
		this.nome = nome;
		this.resp = resp;
	}

	public Participante responsavel() {
		return resp;
	}

	public String codigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public Servico getServico() {
		return null;
	}

	@Override
	public String toString() {
		return "Stand [codigo=" + codigo + ", nome=" + nome + ", resp=" + resp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((resp == null) ? 0 : resp.hashCode());
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
		Stand other = (Stand) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (resp == null) {
			if (other.resp != null)
				return false;
		} else if (!resp.equals(other.resp))
			return false;
		return true;
	}
	

}
