package Aula11.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class AlineaE {
	
	public static int palavrasTotal = 0;
	
	public static void main(String[] args) throws IOException {
		HashSet<String> palavras = new HashSet<>();
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\samue\\Desktop\\texto.txt"));
		
		
		lines.stream().flatMap(linha->Arrays.stream(linha.split(" "))).forEach(palavra ->{
								palavras.add(palavra);
								palavrasTotal++;
		});
		
		System.out.print("Número Total de Palavras:"+palavrasTotal);
		System.out.print("\nNúmero de Diferentes Palavras:"+palavras.size());
		
		//alinea c
		HashMap<String,Integer> mapa = new HashMap<>();
		lines = Files.readAllLines(Paths.get("C:\\Users\\samue\\Desktop\\texto.txt"));
		lines.stream().flatMap(linha->Arrays.stream(linha.split(" "))).forEach(palavra ->{
						if(mapa.containsKey(palavra))
							mapa.put(palavra, mapa.get(palavra)+1);
						else
							mapa.put(palavra, 1);
		});
		
		mapa.keySet().forEach(s -> System.out.println(s+"\t"+mapa.get(s)));
		
		//alinea d
		System.out.println("--------Alinea d-------");
		TreeMap<String,Integer> tree = new TreeMap<>();
		lines = Files.readAllLines(Paths.get("C:\\Users\\samue\\Desktop\\texto.txt"));
		lines.stream().flatMap(linha->Arrays.stream(linha.split(" "))).forEach(palavra ->{
						if(tree.containsKey(palavra))
							tree.put(palavra, tree.get(palavra)+1);
						else
							tree.put(palavra, 1);
		});
		
		tree.keySet().forEach(s -> System.out.println(s+"\t"+tree.get(s)));

	}

}
