package Aula6.ex2;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String n,int c, Data d) {
		cc = c;
		nome = n;
		dataNasc = d;
	}
	
	public String nome() {
		return nome;
	}
	
	public int cc() {
		return cc;
	}
	
	public Data dataNasc() {
		return dataNasc;
	}
	
	public String toString() {
		return "cc="+cc+", nome="+nome+", dataNasc="+dataNasc;
	}
	
	public int compararNome(Pessoa paraComparar) {
		return (this.nome).compareTo(paraComparar.nome());
	}
	
	public int compararCC(Pessoa paraComparar) {
		if(paraComparar.cc<this.cc) return -1;
		if(paraComparar.cc ==this.cc) return 0;
		return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cc;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cc != other.cc)
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	

}
