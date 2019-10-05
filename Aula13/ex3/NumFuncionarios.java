package Aula13.ex3;

import java.util.*;

public class NumFuncionarios {
	private Map<String,Integer> lista = new HashMap<>();
	
	public void insert(String name) {
		String first = name.split(" ")[0];
		if(lista.containsKey(first)) 
			lista.put(first, lista.get(first)+1);
		else
			lista.put(first, 1);
	}
	
	public boolean remove(String name) {
		String first = name.split(" ")[0];
		if(lista.containsKey(first)) {
			int count = lista.get(first)-1;
			if(count==0) {
				lista.remove(first); 
				return true;
			}
			lista.put(first, count);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return lista.toString();
	}
	
	
	

}
