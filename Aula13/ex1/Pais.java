package Aula13.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pais implements Comparable<Pais>{
	private String nome;
	private Localidade capital;
	private List<Regiao> lista = new ArrayList<>();
	
	public Pais(String nome) {
		this.nome = nome;
	}

	public Pais(String nome, Localidade capital) {
		this.nome = nome;
		if(capital.getTipo() != TipoLocalidade.Cidade)
			throw new IllegalArgumentException("Capital invalida");
		this.capital = capital;
	}
	
	public List<Regiao> getLista() {
		return lista;
	}
	
	public void addRegiao(Regiao r) {
		lista.add(r);
	}
	
	public int popula�ao() {
		return lista.stream().collect((Collectors.summingInt(Regiao::getPopulacao)));
	}

	@Override
	public int compareTo(Pais o) {
		return nome.compareTo(o.nome);
	}

	@Override
	public String toString() {
		return String.format("Pais: %s, Popula�ao: %d (Capital: %s)", nome,popula�ao(),capital!=null?capital:"*Indefinida*");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public void removeRegiao(Regiao r) {
		lista.remove(r);
	}
	
	public void removeCapital() {
		capital = null;
	}

	public void sort() {
		lista.sort((r1,r2)-> r1.getPopulacao()<r2.getPopulacao()?1:-1);
	}
	
}
