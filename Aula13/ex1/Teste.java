package Aula13.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teste {
	
	public static void main(String[] args) {
		Localidade cid1 = new Localidade("Szohod", 31212,
		TipoLocalidade.Cidade);
		Localidade cid2 = new Localidade("Wadesdah", 23423,
		TipoLocalidade.Cidade);
		Localidade cid3 = new Localidade("BedRock", 23423,
		TipoLocalidade.Vila);
		Estado est1 = new Estado("North Borduria", 223133, cid1);
		Estado est2 = new Estado("South Borduria", 84321, cid2);
		Pais p1 = new Pais("Borduria", est1.getCapital());
		Pais p2 = new Pais("Khemed", cid2);
		Pais p3 = new Pais("Aurelia");
		Pais p4 = new Pais("Atlantis");
		p1.addRegiao(est1);
		p1.addRegiao(est2);
		p2.addRegiao(new Provincia("Afrinia", 232475, "Aluko Pono"));
		p2.addRegiao(new Provincia("Eriador", 100000, "Dumpgase Liru"));
		p2.addRegiao(new Provincia("Laurania", 30000, "Mukabamba Dabba"));
		List<Pais> org = new ArrayList<Pais>();
		org.add(p1);
		org.add(p2);
		org.add(p3);
		org.add(p4);
		System.out.println("----Iterar sobre o conjunto");
		Iterator<Pais> itr = org.iterator();
		while (itr.hasNext())
		System.out.println(itr.next());
		System.out.println("-------Iterar sobre o conjunto - For each (java 8)");
		for (Pais pais: org)
		System.out.println(pais);
		// ToDo:
		// adicionar, remover, ordenar, garantir elementos �nicos
		System.out.println("----Alinea c");
		p1.sort();
		System.out.println("----Regioes ordenadas");
		for (Regiao reg: p1.getLista())
			System.out.println(reg);
		p1.removeRegiao(est1);
		p1.removeRegiao(est2);
		System.out.println(p1);
		//p2 = new Pais("Khemed", cid3);
	}

}
