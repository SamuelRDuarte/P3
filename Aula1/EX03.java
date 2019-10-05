package Aula1;
import java.util.*;
import static java.lang.System.*;

public class EX03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(in);
		
		out.println("----Figuras Geometricas----");
		out.println("1--Criar Circulo");
		out.println("2--Criar Quadrado");
		out.println("3--Criar Rectangulo");
		out.print("\nFigura:");
		int escolha = Integer.parseInt(sc.nextLine());
		
		Circulo circulo = null;
		Quadrado quadrado = null;
		Rectangulo rectangulo = null;
		
		switch(escolha){
		case 1:
			out.print("Raio:");
			double raio = Double.parseDouble(sc.nextLine());
			out.print("Coordenada x do centro:");
			double x = Double.parseDouble(sc.next());
			out.print("Coordenada y do centro:");
			double y = Double.parseDouble(sc.next());
			
			circulo = new Circulo(x,y,raio);
			out.println("\nInformaçao do circulo:\n"+circulo.toString());
			break;
		case 2:
			out.println("Lado: ");
			double lado = Double.parseDouble(sc.nextLine());
			out.print("Coordenada x do centro:");
			double x1 = Double.parseDouble(sc.next());
			out.print("Coordenada y do centro:");
			double y2 = Double.parseDouble(sc.next());
			
			quadrado = new Quadrado(x1,y2,lado);
			out.println("\nInformaçao do quadrado:\n"+quadrado.toString());
			break;
		case 3:
			out.println("Comprimento: ");
			double comprimento = Double.parseDouble(sc.nextLine());
			out.println("Largura: ");
			double largura = Double.parseDouble(sc.nextLine());
			out.print("Coordenada x do centro:");
			double x3 = Double.parseDouble(sc.next());
			out.print("Coordenada y do centro:");
			double y3 = Double.parseDouble(sc.next());
			
			rectangulo = new Rectangulo(x3,y3,largura,comprimento);
			out.println("\nInformaçao do rectangulo:\n"+rectangulo.toString());
			break;
		}
		
		//Figuras para testar as funçoes intersetar e igual
		
		Circulo circulo2 = new Circulo(5,0,4);
		Circulo circulo3 = new Circulo(2,4,5);
		Quadrado quadrado2 = new Quadrado(2,3,4);;
		Rectangulo rectangulo2 = new Rectangulo(3,4,5,2);
		
		if(circulo != null) {
			out.println("É um circulo de raio 4: "+circulo.equals(circulo2));
			out.println("Interseta o circulo com centro no ponto "+circulo3.getCentro()+" e de raio "+circulo3.getRaio()+": "+circulo.intersecao(circulo3));
			out.println("Interseta o circulo com centro no ponto "+circulo2.getCentro()+" e de raio "+circulo2.getRaio()+": "+circulo.intersecao(circulo2));
		}
		
		if(quadrado != null) {
			out.println("É um quadrado de lado 4: "+quadrado.equals(quadrado2));
		}
		if(rectangulo != null) {
			out.println("É um rectangulo de largura 5 e comprimento 2: "+rectangulo.equals(rectangulo2));
		}
		
		
		
		
		
	}
				

}

