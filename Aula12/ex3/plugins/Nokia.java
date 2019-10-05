package Aula12.ex3.plugins;

import java.io.*;
import java.util.*;
import Aula12.ex3.*;

public class Nokia implements Plugin {

	@Override
	public Pessoa[] readFromFile(String file) throws IOException {
		Scanner scf = new Scanner(new File (file));
		scf.nextLine();
		
		List<Pessoa> lista = new ArrayList<>();
		while (scf.hasNextLine()){
			String nome = scf.nextLine();
			int contacto = Integer.parseInt(scf.nextLine());
			String[] data = scf.nextLine().split("/");
			if(scf.hasNextLine()) scf.nextLine();
			lista.add(new Pessoa(nome,new Data(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])),contacto));
			
		}
		scf.close();
		return lista.toArray(new Pessoa[0]);
		
	}

	@Override
	public void writeToFile(String file, Pessoa[] lista) throws IOException {
		PrintWriter pwf = new PrintWriter(new File(file));
		pwf.println("CSV");
		
		for (Pessoa pessoa : lista) {
			pwf.println(pessoa.nome());
			pwf.println(pessoa.contacto());
			pwf.println(pessoa.dataNasc());
			pwf.println();
		}
		pwf.close();

	}

}
