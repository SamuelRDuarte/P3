package Aula6.ex1;

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Ementa2 {
	
	final static Scanner sc = new Scanner(in);
	private static Alimento[] ali = new Alimento[0];
	private static Prato[] pr = new Prato[0];
	private static Ementa ementa = new Ementa("Ementa","UA");

	public static void main(String[] args) {
		int o;
		do {
			do{
				out.println("\n******EMENTA*********");
				out.println("1 - Adicionar ingrediente");
				out.println("2 - Alterar prato");
				out.println("3 - Alterar Ementa");
				out.print("Opção -> ");
				o = sc.nextInt();
				sc.nextLine();
			}while(o<1 || o>3);

			if(o==1){
				do {
					out.println("\n1 - Adicionar Carne");
					out.println("2 - Adicionar Peixe");
					out.println("3 - Adicionar Cereal");
					out.println("4 - Adicionar Legume");
					out.print("Opção -> ");
					o = sc.nextInt();
					sc.nextLine();
				} while (o<1 || o>4);
				if(o==1)
					addCarne();
				else if(o==2)
					addPeixe();
				else if(o==3)
					addCereal();
				else
					addLegume();
			}
			else if(o==2){
				do {
					out.println("\n1 - Cria prato");
					out.println("2 - Apaga prato");
					out.println("3 - Adiciona ingrediente");
					out.println("4 - Remove ingrediente");
					out.print("Opção -> ");
					o = sc.nextInt();
					sc.nextLine();
				} while (o<1 || o>4);
				if(o==1)
					criaPrato();
				else if(o==2)
					apagaPrato();
				else if(o==3)
					addIng();
				else
					removeIng();
			}
			else{
				do {
					out.println("\n1 - Adiciona prato");
					out.println("2 - Remove prato");
					out.println("3 - Imprime ementa");
					out.print("Opção -> ");
					o = sc.nextInt();
					sc.nextLine();
				} while (o<1 || o>3);
				if(o==1)
					addPrato();
				if(o==2)
					removePrato();
				else
					System.out.print(ementa.toString());
			}
		}while (1==1);
	}
	
	public static void addCarne() {
		int x;
		do {
			out.println("Escolha a variedade de carne:");
			out.println("1-Vaca");
			out.println("2-Porco");
			out.println("3-Peru");
			out.println("4-Frango");
			out.println("5-Outra");
			out.print("Escolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>5);
		
		out.print("\nProteinas: ");
		double pro = sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal = sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		
		addArrayIng(new Carne(VariedadeCarne.getVarCarne(x),pro,cal,peso));
	}
	
	public static void addPeixe() {
		int x;
		do {
			out.println("Escolha o tipo de peixe:");
			out.println("1-Congelado");
			out.println("2-Fresco");
			out.print("Escolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>2);
		
		out.print("\nProteinas: ");
		double pro = sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal = sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		
		addArrayIng(new Peixe(TipoPeixe.getTipo(x),pro,cal,peso));
	}
	
	public static void addLegume() {
		out.print("\nNome: ");
		String nome =sc.nextLine();
		out.print("\nProteinas: ");
		double pro = sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal = sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		
		addArrayIng(new Legume(nome,pro,cal,peso));
	}
	
	public static void addCereal() {
		out.print("\nNome: ");
		String nome =sc.nextLine();
		out.print("\nProteinas: ");
		double pro = sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal = sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		
		addArrayIng(new Cereal(nome,pro,cal,peso));
	}
	
	public static void criaPrato() {
		int x;
		do {
			out.println("Escolha o tipo de prato:");
			out.println("1-Normal");
			out.println("2-Vegetariano");
			out.println("3-Dieta");
			out.print("Escolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>3);
		
		out.print("\nNome do prato: ");
		String nome =sc.nextLine();
		
		if (x==1) {
			addArrayPrato(new Prato(nome));
		} else if(x == 2) {
			addArrayPrato(new PratoVegetariano(nome));	
		}else {
			out.print("\nMaximo de calorias: ");
			double cal = sc.nextDouble();
			sc.nextLine();
			addArrayPrato(new PratoDieta(nome,cal));
		}
	}
	
	public static void apagaPrato() {
		int x;
		if (pr.length<1) {
			out.print("\nNao existem pratos");
			return;
		}
		
		do {
			out.print("\nEscolha o numero do prato que deseja apagar: ");
			out.print(listPratos());
			out.print("\nEscolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>pr.length);
		x--;
		
		Prato[] c = new Prato[pr.length-1];
		for (int i = 0; i < c.length; i++) {
			if(i<x)
				c[i]=pr[i];
			if(i>x)
				c[i-1]=pr[i];
		}
		pr=c;
	}
	
	public static void addIng() {
		int x,j;
		if (pr.length<1) {
			out.print("\nNao existem pratos");
			return;
		}
		do {
			out.print("\nEscolha o numero do prato que deseja alterar: ");
			out.print(listPratos());
			out.print("\nEscolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>pr.length);
		x--;
		do {
			out.print("\nEscolha o numero do ingrediente que deseja adicionar: ");
			out.print(listIng());
			out.print("\nEscolha -> ");
			j = sc.nextInt();
			sc.nextLine();
		} while (j<1||j>ali.length);
		j--;
		
		if(pr[x].addIngrediente(ali[j]))
			out.print("\nIngrediente adicionado");
		else
			out.print("\nIngrediente nao adicionado");
	}
	
	public static void removeIng() {
		int x,j;
		if (pr.length<1) {
			out.print("\nNao existem pratos");
			return;
		}
		do {
			out.print("\nEscolha o numero do prato que deseja alterar: ");
			out.print(listPratos());
			out.print("\nEscolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>pr.length);
		x--;
		do {
			out.print("\nEscolha o numero do ingrediente que deseja retirar: ");
			out.print(listIng());
			out.print("\nEscolha -> ");
			j = sc.nextInt();
			sc.nextLine();
		} while (j<1||j>ali.length);
		j--;
		
		if(pr[x].contains(ali[j])) {
			pr[x].removeIngrediente(ali[j]);
			out.print("\nIngrediente removido");
		}else
			out.print("\nIngrediente nao removido");
	}
	
	public static void addPrato() {
		int x,j;
		if (pr.length<1) {
			out.print("\nNao existem pratos");
			return;
		}
		do {
			out.print("\nEscolha o numero do prato que deseja adicionar na ementa: ");
			out.print(listPratos());
			out.print("\nEscolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>pr.length);
		x--;
		
		do {
			out.print("\nEscolha o dia do prato na ementa:");
			out.print("\n1-Segunda");
			out.print("\n2-Terça");
			out.print("\n3-Quarta");
			out.print("\n4-Quinta");
			out.print("\n5-Sexta");
			out.print("\n6-Sabado");
			out.print("\n7-Domingo");
			out.print("\nEscolha -> ");
			j = sc.nextInt();
			sc.nextLine();
		} while (j<1||j>7);
		j--;
		ementa.addPrato(pr[x], DiaSemana.enumDia(j));
		out.print("\nPrato adicionado na ementa");
	}
	
	public static void removePrato() {
		int x,j;
		if (pr.length<1) {
			out.print("\nNao existem pratos");
			return;
		}
		do {
			out.print("\nEscolha o numero do prato que deseja remover na ementa: ");
			out.print(listPratos());
			out.print("\nEscolha -> ");
			x = sc.nextInt();
			sc.nextLine();
		} while (x<1||x>pr.length);
		x--;
		
		do {
			out.print("\nEscolha o dia do prato na ementa:");
			out.print("\n1-Segunda");
			out.print("\n2-Terça");
			out.print("\n3-Quarta");
			out.print("\n4-Quinta");
			out.print("\n5-Sexta");
			out.print("\n6-Sabado");
			out.print("\n7-Domingo");
			out.print("Escolha -> ");
			j = sc.nextInt();
			sc.nextLine();
		} while (j<1||j>7);
		j--;
		ementa.removePrato(pr[x], DiaSemana.enumDia(j));
		
	}
	
	private static String listIng() {
		String s = "";
		for (int i = 0; i < ali.length; i++) {
			s+= "\n"+(i+1)+" - "+ali[i].toString();
		}
		return s;
	}
	
	private static String listPratos() {
		String s = "";
		for (int i = 0; i < pr.length; i++) {
			s+= "\n"+(i+1)+" - "+pr[i].toString();
		}
		return s;
	}
	
	private static void addArrayIng(Alimento a) {
		Alimento[] c = new Alimento[ali.length+1];
		for (int i = 0; i < ali.length; i++) {
			c[i]=ali[i];
		}
		c[ali.length]=a;
		ali=c;
	}
	
	private static void addArrayPrato(Prato a) {
		Prato[] c = new Prato[pr.length+1];
		for (int i = 0; i < pr.length; i++) {
			c[i]=pr[i];
		}
		c[pr.length]=a;
		pr=c;
	}

}
