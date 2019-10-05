package Aula7.ex1;

import java.util.*;
import java.io.*;

public class Test {

	public static void main(String[] args) throws IOException{
		Aeroporto aeroporto = new Aeroporto("C:\\Users\\samue\\OneDrive - Universidade de Aveiro\\Universidade\\2Ano\\P3\\P3_Alulas\\src\\voos.txt","C:\\Users\\samue\\OneDrive - Universidade de Aveiro\\Universidade\\2Ano\\P3\\P3_Alulas\\src\\companhias.txt");
		aeroporto.excrever();
		
		aeroporto.saveToFile("Infopublico2.txt");
		System.out.println();
		aeroporto.atrasoMedio();
		
		aeroporto.cidades("C:\\Users\\samue\\OneDrive - Universidade de Aveiro\\Universidade\\2Ano\\P3\\P3_Alulas\\src\\cidades.txt");
		
		aeroporto.saveToBinary("Infopublic.bin");
		System.out.println();
		aeroporto.readBinaryFile("Infopublic.bin");
	}

}
