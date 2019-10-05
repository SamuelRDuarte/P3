package Aula9.ex3;

import java.util.*;

public class ListaPessoasBFIterator {
	
	private List<Pessoa> lista = new LinkedList<Pessoa>();
	
	public boolean addPessoa(Pessoa p) {
		return lista.add(p);
	}
	
	public boolean removePessoa(Pessoa p) {
		return lista.remove(p);
	}
	
	public int totalPessoas() {
		return lista.size();
	}
	
	BFIterator iterator() {
		return (this).new ListaPessoaIterator();
	}
	
	private class ListaPessoaIterator implements BFIterator {
		
		private int index = 0;

		@Override
		public boolean hasPrevious() {
			return index >=0;
		}

		@Override
		public Object previous() {
			if(index <0)
				throw new NoSuchElementException();
			Object obj = lista.get(index);
			index--;
			return obj;
		}

		@Override
		public boolean hasNext() {
			return index<lista.size();
		}

		@Override
		public Object next() {
			if(hasNext()) {
				Object obj = lista.get(index);
				index++;
				return obj;
			}
			throw new IndexOutOfBoundsException("apenas "+ lista.size()+"elementos");
		}
		
	}

}
