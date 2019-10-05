package Aula10.ex1;

import java.util.*;

public class ListaGeneric<T>{
	
	private List<T> lista;

	public ListaGeneric() {
		lista = new LinkedList<>();
	}
	
	public boolean addElem(T elem) {
		return lista.add(elem);
	}
	
	public boolean removeElem(T elem) {
		return lista.remove(elem);
	}
	
	public int totalElem() {
		return lista.size();
	}
	
	Iterator<T> iterator(){
		return lista.iterator();
	}
	

}
