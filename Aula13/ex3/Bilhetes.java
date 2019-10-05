package Aula13.ex3;

import java.util.*;

public class Bilhetes {
	private int index =0;
	private String[] func;
	
	public Bilhetes(String[] func) {
		this.func = func;
	}
	
	public List<String> giveBilhetes(int n){
		List<String> premios = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			premios.add(giveBilhete());
		}
		return premios;
	}
	
	private String giveBilhete() {
		index =(index+1) % func.length;
		return func[index];
	}

}
