package Aula7.ex1;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;

public class Aeroporto {
	private List<Voo> voos = new ArrayList<>();
	private HashMap<String,Companhia> siglas = new HashMap<>();
	
	public Aeroporto(String voosFile,String compFile) throws IOException {
		List<String> info = Files.readAllLines(Paths.get(voosFile));
		List<String> infoComp = Files.readAllLines(Paths.get(compFile));
		
		for (int i = 0; i < infoComp.size(); i++) {
			if(i== 0) continue;
			String[] linha = infoComp.get(i).split("\t");
			siglas.put(linha[0], new Companhia(linha[0],linha[1]));
		}
		
		for (int i = 0; i < info.size(); i++){
			if(i==0) continue;
			String[] linha = info.get(i).split("\t");
			Companhia comp = siglas.get(linha[1].substring(0, 2));
			if(comp == null) continue;
			Hora atraso = new Hora();
			if(linha.length>3)
				atraso = new Hora(linha[3]);
			voos.add(new Voo(new Hora(linha[0]),linha[1],comp,linha[2],atraso));
 		}
	}
	
	public void excrever() {
		System.out.println("Hora\tVoo\t\tCompanhia\t\tOrigem\t\t\tAtraso\tObs");
		for (Voo voo : voos) {
			System.out.println(voo);
		}
	}
	
	public String toString() {
		String s="Hora	Voo			Companhia			Origem					Atraso	Obs\n";
		for (Voo voo : voos.toArray(new Voo[0])) {
			s+=voo+"\n";
		}
		return s;
	}
	
	public void saveToFile(String file)throws IOException {
		//Files.write(Paths.get(file), toString().getBytes());
		FileWriter fw = new FileWriter(new File(file));
		fw.write(toString());
		fw.close();
	}
	
	public void atrasoMedio() {
		HashMap<Companhia,Integer> atrasosTabela = new HashMap<>();
		
		for (Companhia companhia : siglas.values().toArray(new Companhia[0])) {
			int soma=0;
			int count=0;
			for (Voo voo : voos.toArray(new Voo[0])) {
				if(voo.getCompanhia() == companhia) {
					soma += voo.atrasoMinutos();
					count++;
				}
				
			}
			atrasosTabela.put(companhia, (int)((double)soma/(double)count));
		}
		
		Companhia[] sorted = atrasosTabela.keySet().toArray(new Companhia[0]);
		Arrays.sort(sorted, new Comparator<Companhia>() {
			
				public int compare(Companhia a,Companhia d) {
					return atrasosTabela.get(a)-atrasosTabela.get(d);
				}
		});
		
		System.out.println("Companhia\t\tAtraso");
		for (Companhia companhia : sorted) {
			System.out.printf("%-18s\t%s\n",companhia,new Hora(atrasosTabela.get(companhia)));
		}
	}
	
	public void cidades(String nome) throws IOException {
		Hashtable<String,Integer> origem = new Hashtable<>();
		List<String> ficheiro = new ArrayList<>();
		int i;
		ficheiro.add("Origem\t\t\tVoo\n");
		
		for(Voo voo  : voos) {
			if (origem.containsKey(voo.getOrigem())) {
				origem.put(voo.getOrigem(), origem.get(voo.getOrigem())+1);
			}else {
				origem.put(voo.getOrigem(), 1);
			}
		}
		
		String[] cidades = (origem.keySet()).toArray(new String[0]);
		Iterator<Integer> iter = (origem.values()).iterator();
		int[] vooss = new int[origem.size()];
		for (int j = 0; j < vooss.length; j++) {
			vooss[j]=iter.next();
		}
		
		boolean swap;
		String aux;
		do
		{
			swap = false;
			for(i = 0; i < vooss.length -1; i++)
			{
				if (vooss[i] < vooss[i+1])
				{
					// swap city
					aux = cidades[i];
					cidades[i] = cidades[i+1];
					cidades[i+1] = aux;
					
					// swap city value
					vooss[i] = vooss[i] + vooss[i+1];
					vooss[i+1] = vooss[i] - vooss[i+1];
					vooss[i] = vooss[i] - vooss[i+1];
					
					swap = true;
				}
			}
		}while(swap);
		
		for (int j = 0; j < vooss.length; j++) {
			ficheiro.add(String.format("%-20s\t%d",cidades[j],vooss[j]));
		}
		
		Files.write(Paths.get(nome),ficheiro,Charset.forName("UTF-8"));
	}
	
	public void readBinaryFile(String nome) throws IOException {
		RandomAccessFile ficheiro = new RandomAccessFile(nome,"rw");
		byte[] info = new byte[(int)ficheiro.length()];
		ficheiro.readFully(info);
		ficheiro.close();
		System.out.println(new String(info));
	}
	
	public void saveToBinary(String nome) throws IOException{
		RandomAccessFile ficheiro = new RandomAccessFile(nome,"rw");
		
		ficheiro.write(toString().getBytes());
		ficheiro.close();
	}
}
