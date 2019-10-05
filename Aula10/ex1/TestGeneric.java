package Aula10.ex1;


import java.util.Iterator;

import Aula6.ex2.Circulo;
import Aula6.ex2.Figura;
import Aula6.ex2.Quadrado;
import Aula6.ex2.Rectangulo;
import Aula9.ex3.Data;
import Aula9.ex3.Pessoa;

public abstract class TestGeneric {
	public static void main(String[] args) {
		VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
		for (int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebé no Vector "+i,
					1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());
		
		System.out.println("Começo da lista");
		
		ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
		while ( vec.hasNext() )
			lp.addElem( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		ListaGeneric<Figura> figList = new ListaGeneric<Figura>();
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));
		figList.addElem(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator()); 
		
		System.out.println("Soma da Area de Lista de Figuras: " +  sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		ListaGeneric< Rectangulo > quadList =  new ListaGeneric<Rectangulo>();   
		quadList.addElem(new Quadrado(3,4, 2));   quadList.addElem(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " +          
									sumArea(quadList));  
	}

	private static double sumArea(ListaGeneric<? extends Figura> lista) {
		double soma = 0;
		
		Iterator it = lista.iterator();
		while(it.hasNext())
			soma+=((Figura)it.next()).getArea();
		return soma;
		
	}

	private static void printSet(Iterator iterator) {
		while(iterator.hasNext())
			System.out.println(iterator.next().toString());
		
	} 
} 
