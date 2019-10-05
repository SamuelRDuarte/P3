package Aula1;

import java.util.*;
import static java.lang.System.*;

public class Ex02 {

	public static void main(String[] args) {
		
		Agenda lista = new Agenda(20);
		
		int x = 0;
		
		do{
			x = menu();
			switch(x){
			case 1:
				lista.addPessoa();
				break;
			
			case 2:
				lista.delPessoa();
				break;
			
			case 3:
				lista.print();
				break;
			case 4:
				lista.ordenarNome();
				break;
			case 5:
				lista.ordenarCC();
				break;
			case 6:
				out.println("Programa fechado");
				
				
			}
			
		}while(x!=6);
		

	}
	
	private static int menu() {
		Scanner sc = new Scanner(in);
		
		out.println("\n----Menu----");
		out.println("1--Adicionar pessoa");
		out.println("2--Apagar pessoa");
		out.println("3--Lista de pessoas");
		out.println("4--Ordenar por nome");
		out.println("5--Ordenar por cc");
		out.println("6--Fechar o programa");
		out.print("Escolha:");
		int n = sc.nextInt(); 
		
		while(n<1 || n>6) {
			out.println("\nEscolha indisponivel. Tente novamente");
			n = sc.nextInt();
		}
		
		return n;
	}
	
		

}
