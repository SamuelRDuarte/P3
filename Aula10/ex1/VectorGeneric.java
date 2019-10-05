package Aula10.ex1;

import java.util.Iterator;

public class VectorGeneric<T> {
	private T[] lista;
	private int nElementos;
	private final int size = 20;
	private int dimensao = size;
	
	public VectorGeneric() {
		lista = (T[]) new Object[size];
		nElementos = 0;
	}
	
	public boolean addElem(T elem) {
		if(elem == null) return false;
		if(nElementos>=dimensao) {
			dimensao +=size;
			T[] array = (T[]) new Object[dimensao];
			System.arraycopy(lista, 0, elem, 0, nElementos);
			lista = array;
		}
		lista[nElementos++] = elem;
		return true;
	}
	
	public boolean removeElem(T elem) {
		for (int i = 0; i < nElementos; i++) {
			if(lista[i] == elem) {
				nElementos--;
				for (int j = 0; j < nElementos; j++) {
					lista[j] = lista[j+1];
				}
				return true;
			}
			
		}
		return false;
	}
	
	public int totalElem() {
		return nElementos;
	}
	
	Iterator<T> iterator(){
		return (this).new VectorIterator();
	}
	
	
	private class VectorIterator implements Iterator<T>{
		private int index;
		
		VectorIterator(){ index = 0;}
		
		

		@Override
		public boolean hasNext() {
			return (index<nElementos);
		}

		@Override
		public T next() {
			if(hasNext()) {
				T obj = (T)lista[index];
				index++;
				return obj;
			}
			throw new IndexOutOfBoundsException("apenas "+ nElementos+"elementos");
		}
		
		public void remove() {
			removeElem(lista[index]);
		}
		
	}

}
