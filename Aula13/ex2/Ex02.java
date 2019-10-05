package Aula13.ex2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex02 {
	private Map<String,Map<String,Integer>> mapa = new TreeMap<>();
	
	public Ex02(String path) throws IOException {
		carregarPalavras(lerFicheiro(path));
	}
	
	
	private String[] lerFicheiro(String ficheiro) throws IOException {
		return Arrays.stream(Files.readAllLines(Paths.get(ficheiro)).stream().collect(Collectors.joining(" "))
							.split("[-|\t|\n| |.|,|:|'|,|;|?|!|*|{|}|=|+|&|/|(|)|[|]|\"|'|“|”|‘|’]"))
							.filter(s-> s.length()>=3)
							.map(s -> s.toLowerCase())
							.collect(Collectors.toList()).toArray(new String[0]);
	}
	
	private void carregarPalavras(String[] palavras) {
		for (int i = 0; i < palavras.length-1; i++) {
			String primeira = palavras[i];
			String segunda = palavras[i+1];
			if (mapa.containsKey(primeira)) {
				Map<String,Integer> numeros = mapa.get(primeira);
				if(numeros.containsKey(segunda))
					numeros.put(segunda, numeros.get(segunda)+1);
				else
					numeros.put(segunda, 1);
			}else {
				Map<String,Integer> pala = new TreeMap<>();
				pala.put(segunda, 1);
				mapa.put(primeira, pala);
			}
		}
	}

	@Override
	public String toString() {
		return mapa.keySet().stream().map(s-> s.concat("=").concat(mapa.get(s).toString())).collect(Collectors.joining("\n"));
	}
	
	public static void main(String[] args) throws IOException {
		Ex02 teste = new Ex02("Policarpo.txt");
		/*FileWriter fw = new FileWriter("output.txt");
		fw.write(teste.toString());
		fw.close();*/
		PrintStream ps = new PrintStream(new File("output1.txt"));
		ps.println(teste);
		ps.close();
	}
}
