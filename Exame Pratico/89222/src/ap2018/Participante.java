package ap2018;

public class Participante {

	private String email;
	private String nome;
	
	public Participante(String email, String nome) {
		super();
		this.email = email;
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Participante [email=" + email + ", nome=" + nome + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Participante other = (Participante) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
