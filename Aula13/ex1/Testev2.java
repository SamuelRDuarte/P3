package Aula13.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testev2 {
	public static void main(String[] args) {
			Localidadev2<Cidade> cid1 = new Localidadev2<Cidade>("Szohod", 31212,
			TipoLocalidade.Cidade);
			Localidadev2<Cidade> cid2 = new Localidadev2<Cidade>("Wadesdah", 23423,
			TipoLocalidade.Cidade);
			Localidadev2<Aldeia> cid3 = new Localidadev2<Aldeia>("BedRock", 23423,
			TipoLocalidade.Vila);
			Estadov2 est1 = new Estadov2("North Borduria", 223133, cid1);
			Estadov2 est2 = new Estadov2("South Borduria", 84321, cid2);
			Paisv2 p1 = new Paisv2("Borduria", est1.getCapital());
			Paisv2 p2 = new Paisv2("Khemed", cid2);
			Paisv2 p3 = new Paisv2("Aurelia");
			Paisv2 p4 = new Paisv2("Atlantis");
			p1.addRegiao(est1);
			p1.addRegiao(est2);
			p2.addRegiao(new Provincia("Afrinia", 232475, "Aluko Pono"));
			p2.addRegiao(new Provincia("Eriador", 100000, "Dumpgase Liru"));
			p2.addRegiao(new Provincia("Laurania", 30000, "Mukabamba Dabba"));
			List<Paisv2> org = new ArrayList<>();
			org.add(p1);
			org.add(p2);
			org.add(p3);
			org.add(p4);
			System.out.println("----Iterar sobre o conjunto");
			Iterator<Paisv2> itr = org.iterator();
			while (itr.hasNext())
			System.out.println(itr.next());
			System.out.println("-------Iterar sobre o conjunto - For each (java 8)");
			for (Paisv2 pais: org)
			System.out.println(pais);
			// ToDo:
			// adicionar, remover, ordenar, garantir elementos únicos
			System.out.println("----Alinea c");
			p1.sort();
			System.out.println("----Regioes ordenadas");
			for (Regiao reg: p1.getLista())
				System.out.println(reg);
			p1.removeRegiao(est1);
			p1.removeRegiao(est2);
			System.out.println(p1);
			//p2 = new Paisv2("Khemed", cid3); //erro de compilaçao
			}
}
