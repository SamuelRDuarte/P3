package Aula1;

import java.util.*;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduza a frase:");
		String frase = sc.nextLine();
		
		countNum(frase);
		isLower(frase);
		isUpper(frase);
		countWords(frase);
		
		char tmp = ' ';
		String trocas = "";
		
		for(int i = 0;i<frase.length();i++) {
			if(i%2==0) {
				tmp = frase.charAt(i);
			}else {
				trocas += Character.toString(frase.charAt(i))+Character.toString(tmp);
				tmp = ' ';
			}
		}
		
		if(tmp != ' ') {
			trocas+=tmp;
		}
		
		System.out.println("frase trocada: "+trocas);

	}
	
	public static void countNum(String frase){
		int count = 0;
		
		for (int i = 0; i < frase.length(); i++){
			if(Character.isDigit(frase.charAt(i))){
				count++;
			}
		}
		
		if (count == 0){
			System.out.println("A frase nao tem caracteres numericos");
		}else{
			System.out.printf("A frase tem %d caracteres numericos",count);
		}
		
	}
	
	public static void isLower(String frase) {
		boolean minusculas = true;
		
		for(int i = 0;i<frase.length(); i++) {
			if(Character.isUpperCase(frase.charAt(i))) {
				minusculas = false;
			}
		}
		
		if(minusculas) {
			System.out.println("A frase só tem minusculas");
		}else {
			System.out.println("A frase nao tem só minusculas");
		}
	}
	
	public static void isUpper(String frase) {
		boolean minusculas = true;
		
		for(int i = 0;i<frase.length(); i++) {
			if(Character.isLowerCase(frase.charAt(i))) {
				minusculas = false;
			}
		}
		
		if(minusculas) {
			System.out.println("A frase só tem maiusculas");
		}else {
			System.out.println("A frase nao tem só maiusculas");
		}
	}
	
	public static void countWords(String frase) {
		
		String[] palavras = frase.split(" ");
		
		System.out.println("A frase tem "+palavras.length+" palavras");
		
	}


}
