package Aula9.ex3;

import java.util.Iterator;

public class VectorPessoas {
	
	private Pessoa[] listaPessoas;
	private int nPessoas;
	private final int size = 20;
	private int dimensao = size;
	
	public VectorPessoas() {
		listaPessoas = new Pessoa[size];
		nPessoas = 0;
	}
	
	public boolean addPessoa(Pessoa p) {
		if(p == null) return false;
		if(nPessoas>=dimensao) {
			dimensao +=size;
			Pessoa[] peps = new Pessoa[dimensao];
			System.arraycopy(listaPessoas, 0, p, 0, nPessoas);
			listaPessoas = peps;
		}
		listaPessoas[nPessoas++] = p;
		return true;
	}
	
	public boolean removePessoa(Pessoa p) {
		for (int i = 0; i < nPessoas; i++) {
			if(listaPessoas[i] == p) {
				nPessoas--;
				for (int j = 0; j < nPessoas; j++) {
					listaPessoas[j] = listaPessoas[j+1];
				}
				return true;
			}
			
		}
		return false;
	}
	
	public int totalPessoas() {
		return nPessoas;
	}
	
	Iterator iterator() {
		return (this).new VectorIterator();
	}
	
	
	
	private class VectorIterator implements Iterator{
		private int index;
		
		VectorIterator(){ index = 0;}
		
		

		@Override
		public boolean hasNext() {
			return (index<nPessoas);
		}

		@Override
		public Object next() {
			if(hasNext()) {
				Object obj = listaPessoas[index];
				index++;
				return obj;
			}
			throw new IndexOutOfBoundsException("apenas "+ nPessoas+"elementos");
		}
		
		public void remove() {
			removePessoa(listaPessoas[index]);
		}
		
	}

}
