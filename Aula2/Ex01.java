package Aula2;

import static java.lang.System.*;

import java.util.*;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		
		int n;
		do {
			out.println("\nNumero maximo de quotas de emprestimo: ");
			n = sc.nextInt();
			sc.nextLine();
			if(n<0) out.println("Numero invalido");
		}while(n<0);
		
		VideoClube clube = new VideoClube(n);
		int x = 0;
		
		
		do {
			x = menu();
			switch(x) {
			case 1: 
				if(clube.addCl() == 1) clube.addEst();
				else clube.addFunc();
				break;
			case 2:
				if(clube.addCl() == 1) clube.dellEst();
				else clube.dellFunc();
				break;
			case 3:
				clube.addVid();
				break;
			case 4:
				clube.delVid();
				break;
			case 5:
				clube.checkLoan();
				break;
			case 6:
				clube.pesVid();
				break;
			case 7:
				clube.loan();
				break;
			case 8:
				clube.devVid();
				break;
			case 9:
				clube.userReq();
				break;
			case 10:
				clube.vidByCl();
				break;
			case 11:
				if(clube.addCl() == 1) clube.lisVidEst();
				else clube.lisVidFunc();
				break;
			case 12:
				clube.listRat();
				break;
			case 0:
				out.println("Programa terminado");
				break;
			}
			
		}while(x!=0);
		
		

	}
	
	public static int menu() {
		Scanner sc = new Scanner(in);
		
		out.println("\n----Menu----");
		out.println("1--Adicionar utilizador");
		out.println("2--Apagar utilizador");
		out.println("3--Adicionar video");
		out.println("4--Apagar video");
		out.println("5--Verificar a disponibilidade de um video");
		out.println("6--Pesquisar videos");
		out.println("7--Efetuar emprestimo");
		out.println("8--Efetuar devolução");
		out.println("9--Ver quem requesitou um video");
		out.println("10-Listar videos disponiveis por utilizador");
		out.println("11-Listar videos emprestados por utilizador");
		out.println("12-Listar videos por rating");
		out.println("0--Fechar programa");
		out.print("Escolha:");
		int n = sc.nextInt(); 
		
		while(n<0 || n>10) {
			out.println("\nEscolha indisponivel. Tente novamente");
			n = sc.nextInt();
		}
		
		return n;
	}

}
