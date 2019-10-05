package Aula8.ex3;

import java.io.IOException;
import java.util.LinkedList;

public class Questoes {
	
	private static final int[] premios = { 25,50,125,250,500,750,1500,2500,5000,10000,16000,3200,6400,125000,250000};
	private final Questao[] questoes;
	private int index;
	
	public Questoes(String fileName) throws IOException{
		LinkedList<Questao> temp = new LinkedList<>();
		Info.info(temp,fileName);
		this.questoes = Info.sort(temp.toArray(new Questao[temp.size()]));
		porPremios(this);
	}
	
	private static void porPremios(Questoes quests) {
		int i = 0;
		for (Questao q : quests.questoes) {
			q.setPremio(premios[i++]);
		}
	}
	
	public Questao getQuestao() {
		return index < questoes.length ? questoes[index++]: null;
	}
	
	public int ultimaQuestaoPremio() {
		return index >0 ? questoes[index-1].getPremio():0;
	}
	
	public boolean naoHaQuestao() {
		return index >= questoes.length;
	}

}
