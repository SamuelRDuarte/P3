package Aula1;

import java.util.*;
import static java.lang.System.*;

public class Agenda {
	
	private int size = 0;
	private static final Scanner sc = new Scanner(in);
	private Pessoa[] lista;
	
	public Agenda(int size) {
		lista = new Pessoa[size];
	}
	
	public int Size() {
		return size;
	}
	
	public void addPessoa() {
		
		if (size >= 20){
			out.printf("Não consegue adicionar mais ninguém à lista, por favor remova alguém antes de adicionar.\n");
			return;
		}
		
		out.print("Nome:");
		String nome = sc.nextLine();
		
		out.print("CC:");
		String x = sc.nextLine();
		int cc = Integer.parseInt(x);
		
		
		out.print("Data (dd/mm/aaaa):");
		String date = sc.nextLine();
		String dat[] = date.split("/");
		int[] datas = new int[3];
		for(int i =0;i<datas.length;i++) {
			datas[i] = Integer.parseInt(dat[i]);
		}
		
		Data data = new Data(datas[0],datas[1],datas[2]);
		
		if(!data.validarData()) {
			out.println("Data incorreta.Pessoa nao adicionada");
			return;
		}
		
		lista[size]= new Pessoa(nome,cc,data);
		
		out.println("Pessoa adicionada");
		size++;
		
	}
	
	private int search(String nome) {
		for(int i = 0; i<size; i++) {
			if(lista[i].nome().equals(nome)){
				return i;
			}
		}
		return -1;
	}
	
	public void delPessoa() {
		out.print("Nome da pessoa:");
		String name = sc.nextLine();
		
		int pos = search(name);
		
		if(pos !=-1) {
			lista[pos]= null;
			
			while(pos<lista.length-1) {
				lista[pos]= lista[pos+1];
				pos++;
			}
			size--;
			out.println("Pessoa removida da lista");
		}else {
			out.println("A pessoa nao esta na lista");
		}
	}
	
	public void print(){
		out.println("\nLista de Pessoas\n");
		
		for(int i =0; i<size;i++) {
			out.printf("#%d : %s\n",i+1,lista[i].toString());
		}
	}
	
	public void ordenarNome() {
		boolean troca = false;
		Pessoa tmp;
		do {
			troca = false;
			for(int i = 0; i<size-1; i++) {
				if(lista[i].compararNome(lista[i+1])>0) {
					tmp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = tmp;
					troca = true;
				}
			}
			
		}while(troca);
	}
	
	public void ordenarCC() {
		boolean troca = false;
		Pessoa tmp;
		do {
			troca = false;
			for(int i = 0; i<size-1; i++) {
				if(lista[i].compararCC(lista[i+1])<0) {
					tmp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = tmp;
					troca = true;
				}
			}
			
		}while(troca);
	}
	
	
	

}
