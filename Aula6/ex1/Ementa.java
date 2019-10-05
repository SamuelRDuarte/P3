package Aula6.ex1;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Ementa {
	
	private String nome;
	private String local;
	private HashMap<DiaSemana, LinkedList<Prato>> pratos = new HashMap<>();
	
	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
	}
	
	public void addPrato(Prato p,DiaSemana d) {
		if(pratos.containsKey(d))
			pratos.get(d).addFirst(p);
		else {
			LinkedList<Prato> tmp = new LinkedList<>();
			tmp.addFirst(p);
			pratos.put(d, tmp);
		}
	}
	
	public void removePrato(Prato p,DiaSemana d) {
		if(pratos.containsKey(d) && pratos.get(d).contains(p)) {
				pratos.get(d).remove(p);
				out.print("\nPrato removido na ementa");
		}else
			System.out.println("\nO prato nao existe");
	}
	@Override
	public String toString() {
		String s ="";
		DiaSemana[] dias = pratos.keySet().toArray(new DiaSemana[0]);
		Arrays.sort(dias);
		for (DiaSemana diaSemana : dias) {
			LinkedList<Prato> lista = pratos.get(diaSemana);
			for(Prato p: lista.toArray(new Prato[0])) {
				s+= p.toString()+", dia "+diaSemana+"\n";
			}
		}
		return s;
	}
	
	

}
