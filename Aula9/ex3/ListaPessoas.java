package Aula9.ex3;

import java.util.*;

public class ListaPessoas {
	
	private List<Pessoa> lista;

	public ListaPessoas() {
		lista = new LinkedList<Pessoa>();
	}
	
	public boolean addPessoa(Pessoa p) {
		return lista.add(p);
	}
	
	public boolean removePessoa(Pessoa p) {
		return lista.remove(p);
	}
	
	public int totalPessoas() {
		return lista.size();
	}
	
	Iterator iterator() {
		return lista.iterator();
	}

}
