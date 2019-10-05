package Aula11.ex2;

import java.util.*;

public class Ex2 {

	public static void main(String[] args) {
		List<Figura> list = new ArrayList<>();
		list.add(new Quadrado(2));
		list.add(new Quadrado(3));
		list.add(new Quadrado(9));	//Maior figura
		list.add(new Rectangulo(1,81));
		list.add(new Rectangulo(5,1));
		list.add(new Quadrado(1));
		list.add(new Quadrado(2));
		list.add(new Quadrado(2));	
		list.add(new Rectangulo(1,1));
		list.add(new Rectangulo(1,1));
		
		System.out.println("Maior figura: "+maiorFiguraJ8(list));
		System.out.println("Maior perimetro: "+maiorFiguraJ8P(list));
		System.out.println("Soma total das areas: "+areaTotalJ8(list));
		System.out.println("Soma total das areas dos quadrados: "+areaTotalJ8(list,"Quadrado"));

	}
	
	private static Figura maiorFiguraJ8(List<Figura> figs) {
		return figs.stream().max(Comparator.naturalOrder()).get();
	}
	
	private static Figura maiorFiguraJ8P(List<Figura> figs) {
		/*return figs.stream().max(new Comparator<Figura>() {
				@Override
				public int compare(Figura fig1,Figura fig2) {
					if(fig1.getPerimetro() > fig2.getPerimetro())
						return 1;
					else if(fig1.getPerimetro() < fig2.getPerimetro())
						return -1;
					else
						return 0;
				}
		}).get();*/
		Comparator<Figura> byPerimetro = Comparator.comparing(Figura::getPerimetro);
		return figs.stream().max(byPerimetro).get();
		 
	}
	
	private static double areaTotalJ8(List<Figura> figs) {
		return figs.stream().mapToDouble(fig->fig.getArea()).reduce(0,(total,area)->total+area);
	}
	
	private static double areaTotalJ8(List<Figura> figs,String subtipoNome) {
		return figs.stream().filter(s->s.getClass().getSimpleName().equals(subtipoNome)).mapToDouble(s->s.getArea()).sum();
	}
	
	
	

}
