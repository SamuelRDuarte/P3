package Aula13.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Paisv2 implements Comparable<Paisv2> {
	private String nome;
	private Localidadev2<Cidade> capital;
	private List<Regiao> lista = new ArrayList<>();
	
	public Paisv2(String nome) {
		this.nome = nome;
	}

	public Paisv2(String nome, Localidadev2<Cidade> capital) {
		this.nome = nome;
		this.capital = capital;
	}
	
	public List<Regiao> getLista() {
		return lista;
	}
	
	public void addRegiao(Regiao r) {
		lista.add(r);
	}
	
	public int populaçao() {
		return lista.stream().collect((Collectors.summingInt(Regiao::getPopulacao)));
	}

	@Override
	public int compareTo(Paisv2 o) {
		return nome.compareTo(o.nome);
	}

	@Override
	public String toString() {
		return String.format("Pais: %s, Populaçao: %d (Capital: %s)", nome,populaçao(),capital!=null?capital:"*Indefinida*");
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
		Paisv2 other = (Paisv2) obj;
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
