package Aula13.ex3;

import java.util.*;
import java.util.stream.Collectors;

public class ToysList {
	
	private String nome;
	private List<String> toys = new LinkedList<>();
	
	public ToysList(String nome) {
		setNome(nome);
	}

	public void setNome(String nome) {
		this.nome = nome.split(" ")[0];
	}
	
	public Object add(String toy) {
		return toys.add(toy);
	}
	
	public boolean remove(String toy) {
		return toys.remove(toy);
	}

	@Override
	public String toString() {
		return toys.stream().map(s->nome.concat(" "+s)).collect(Collectors.toList()).toString();
	}
	
	
}
