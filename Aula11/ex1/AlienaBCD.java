package Aula11.ex1;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class AlienaBCD {

	public static void main(String[] args) throws IOException {
		
		//aliena b
		HashSet<String> palavras = new HashSet<>();
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\samue\\Desktop\\texto.txt"));
		String[] linha;
		int palavrasTotal = 0;
		for (String line : lines) {
			linha = line.split(" ");
			for(String palavra : linha) {
				palavrasTotal++;
				if(!palavras.contains(palavra))
					palavras.add(palavra);
			}
		}
		
		System.out.print("Número Total de Palavras:"+palavrasTotal);
		System.out.print("\nNúmero de Diferentes Palavras:"+palavras.size());
		
		//aliena c
		HashMap<String,Integer> mapa = new HashMap<>();
		lines = Files.readAllLines(Paths.get("C:\\Users\\samue\\Desktop\\texto.txt"));
		for (String line : lines) {
			linha = line.split(" ");
			for(String palavra : linha) {
				if(mapa.containsKey(palavra))
					mapa.put(palavra, mapa.get(palavra)+1);
				else
					mapa.put(palavra, 1);
			}
		}
		for(String chave : mapa.keySet())
			System.out.println(chave+"\t"+mapa.get(chave));
		System.out.println("--------Alinea d-------");
		//aliena d
		TreeMap<String,Integer> tree = new TreeMap<>(Comparator.naturalOrder());
		lines = Files.readAllLines(Paths.get("C:\\Users\\samue\\Desktop\\texto.txt"));
		for(String line : lines){
			linha = line.split(" ");
			for(String palavra : linha) {
				if(tree.containsKey(palavra))
					tree.put(palavra, tree.get(palavra)+1);
				else
					tree.put(palavra, 1);
			}
		}
		
		for(String chave : tree.keySet())
			System.out.println(chave+"\t"+tree.get(chave));

		
	}

}
