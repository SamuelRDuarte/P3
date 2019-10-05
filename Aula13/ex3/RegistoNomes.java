package Aula13.ex3;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RegistoNomes {
	private Set<String> nomes = new TreeSet<>();
	
	public boolean addFuncionario(String s) {
		return nomes.add(s);
	}
	
	public boolean removeFuncionario(String s) {
		return nomes.remove(s);
	}
	
	@Override
	public String toString() {
		return nomes.stream().collect(Collectors.joining("\n"));
	}

}
