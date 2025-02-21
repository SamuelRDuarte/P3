package Aula9.ex3;

import java.util.Iterator;

public abstract class TesteIterator {

	public static void main(String[] args) {
		VectorPessoas vp = new VectorPessoas();
		for (int i=0; i<10; i++)
		vp.addPessoa(new Pessoa("Beb� no Vector "+i,
		 1000+i, Data.today()));
		Iterator vec = vp.iterator();
		while ( vec.hasNext() )
		System.out.println( vec.next() );
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
		lp.addPessoa(new Pessoa("Beb� na Lista "+i,
		 2000+i, Data.today()));
		Iterator lista = lp.iterator();
		while ( lista.hasNext() )
		System.out.println( lista.next() );
		
		System.out.println("-------------- Teste VectorPessoasBFIterator --------------");
		VectorPesssoasBFIterator vetor = new VectorPesssoasBFIterator();
		vetor.addPessoa(new Pessoa("Joaquim",new Data(1,6,1998)));
		vetor.addPessoa(new Pessoa("Andre",new Data(5,2,1997)));
		vetor.addPessoa(new Pessoa("Maria", new Data(8,6,1999)));
		vetor.addPessoa(new Pessoa("Isabel", new Data(3,10,1998)));
		vetor.addPessoa(new Pessoa("Jose", new Data(3,10,1998)));
		
		//Prints the list
		BFIterator bfiterator = vetor.iterator();
		System.out.println("List:");
		while(bfiterator.hasNext()) {
			System.out.println(bfiterator.next());
		}
		
		vetor = new VectorPesssoasBFIterator();
		vetor.addPessoa(new Pessoa("Joaquim",new Data(1,6,1998)));
		vetor.addPessoa(new Pessoa("Andre",new Data(5,2,1997)));
		vetor.addPessoa(new Pessoa("Maria", new Data(8,6,1999)));
		vetor.addPessoa(new Pessoa("Isabel", new Data(3,10,1998)));
		vetor.addPessoa(new Pessoa("Jose", new Data(3,10,1998)));
		
		bfiterator = vetor.iterator();
		for(int i = 0; i < vetor.totalPessoas()-1; i++) {
			bfiterator.next();
		}
		System.out.println("\nReversed:");
		//Prints the list backwards
		while(bfiterator.hasPrevious()) {
			System.out.println(bfiterator.previous());
		}
		System.out.println();
		
		System.out.println("-------------- Teste ListaPessoasBFIterator --------------");
		
		System.out.println();
		ListaPessoasBFIterator list = new ListaPessoasBFIterator();
		list.addPessoa(new Pessoa("Albertina",new Data(1,6,1998)));
		list.addPessoa(new Pessoa("Marco",new Data(5,2,1997)));
		list.addPessoa(new Pessoa("Alexandre", new Data(8,6,1999)));
		list.addPessoa(new Pessoa("Mariana", new Data(3,10,1998)));
		list.addPessoa(new Pessoa("Beatriz", new Data(3,10,1998)));
		
		bfiterator = list.iterator();
		System.out.println("List:");
		while(bfiterator.hasNext()) {
			System.out.println(bfiterator.next());
		}
		
		list = new ListaPessoasBFIterator();
		list.addPessoa(new Pessoa("Albertina",new Data(1,6,1998)));
		list.addPessoa(new Pessoa("Marco",new Data(5,2,1997)));
		list.addPessoa(new Pessoa("Alexandre", new Data(8,6,1999)));
		list.addPessoa(new Pessoa("Mariana", new Data(3,10,1998)));
		list.addPessoa(new Pessoa("Beatriz", new Data(3,10,1998)));
		
		bfiterator = list.iterator();
		for(int i = list.totalPessoas()-2; i >= 0; i--) {
			bfiterator.next();
		}
		System.out.println("\nReversed:");
		while(bfiterator.hasPrevious()) {
			System.out.println(bfiterator.previous());
		}
		System.out.println();
		System.out.println("-------------- Fim dos testes --------------");

	}

}
