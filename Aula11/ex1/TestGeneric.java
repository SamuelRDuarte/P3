package Aula11.ex1; //ex1a
import java.util.*;
import Aula6.ex2.Circulo;
import Aula6.ex2.Figura;
import Aula6.ex2.Quadrado;
import Aula6.ex2.Rectangulo;
import Aula9.ex3.Data;
import Aula9.ex3.Pessoa;

public class TestGeneric {

	public static void main(String[] args) {
		ArrayList<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i,
					1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());
		
		System.out.println("Começo da lista");
		
		LinkedList<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		LinkedList<Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator()); 
		
		System.out.println("Soma da Area de Lista de Figuras: " +  sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		LinkedList< Rectangulo > quadList =  new LinkedList<Rectangulo>();   
		quadList.add(new Quadrado(3,4, 2));   quadList.add(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " +          
									sumArea(quadList));  
	}

	private static double sumArea(LinkedList<? extends Figura> lista) {
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