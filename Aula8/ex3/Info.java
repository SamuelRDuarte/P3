package Aula8.ex3;

import java.io.*;
import java.util.*;

public class Info {
	
	private static Random rand = new Random();
	
	public static void info(Collection<Questao> q, String fileName) throws IOException{
		BufferedReader file  = new BufferedReader(new FileReader(fileName));
		String linhas[] = (file.lines()).toArray(String[]::new);
		
		for (String linha : linhas) {
			String parts[] = linha.split("&&");
			q.add(new Questao(parts[0].split(":")[1],parts[1],parts[2],Integer.parseInt(parts[6]),parts[2],parts[3],parts[4],parts[5]));
		}
		file.close();
	}
	
	public static <T> T[] scrambleArray(T[] ops) {
		T tmp;
		for (int i = ops.length-1,index;i>0; i--) {
			index = rand.nextInt(i+1);
			tmp = ops[index];
			ops[index] = ops[i];
			ops[i] = tmp;
		}
		return ops;
	}
	
	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		Arrays.sort(arr);
		return arr;
	}

}
