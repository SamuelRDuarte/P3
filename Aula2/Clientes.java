package Aula2;
import java.util.*;

public class Clientes {
	
	private static int num = 1;
	private int nSocio;
	private int CC;
	private String nome;
	private Data dataNasc;
	private Video[] vid = new Video[0];
	private int quotas;
	
	public Clientes( int cC, String nome, Data dataNasc,int n) {
		nSocio = num++;
		CC = cC;
		this.nome = nome;
		this.dataNasc = dataNasc;
		quotas = n;
	}
	
	public int getnSocio() {
		return nSocio;
	}
	public int getCC() {
		return CC;
	}
	public String getNome() {
		return nome;
	}
	public Data getDataNasc() {
		return dataNasc;
	}
	public Video[] getVid() {
		return vid;
	}

	@Override
	public String toString() {
		return "Clientes [nSocio=" + nSocio + ", CC=" + CC + ", nome=" + nome + ", dataNasc=" + dataNasc + "]";
	}
	
	public void addVid(Video v) {
		Video[] c = new Video[vid.length+1];
		for(int i = 0;i<vid.length;i++) {
			c[i]= vid[i];
		}
		c[vid.length] = v;
		vid = c;
	}
	
	public int getQuotasLeft() {
		return quotas-vid.length;
	}
	
	
	
	
	
	
	

}
