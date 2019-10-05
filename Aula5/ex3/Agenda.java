package Aula5.ex3;

import java.io.*;
import java.util.*;

public class Agenda {
	
	private List<Pessoa> agenda = new ArrayList<>();
	
	public void addContacto(Pessoa p) {
		agenda.add(p);
	}
	
	public void addContactos(Pessoa[] lista) {
		for (Pessoa pessoa : lista) {
			addContacto(pessoa);
		}
	}
	
	public void removeConctato(Pessoa p) throws Exception {
		if(!agenda.contains(p)) throw new Exception("A pessoa nao existe");
		agenda.remove(p);
	}
	
	public void loadFromFile(String file) throws IOException{
		Scanner scf = new Scanner(new File(file));
		String format = scf.nextLine();
		scf.close();
		
		AgendaFormat tipoAgenda = null;
		
		if (format.equals("CSV")) {
			tipoAgenda = new CSV();
		} else if(format.equals("Nokia")) {
			tipoAgenda = new Nokia();
		}else if(format.equals("vCard")) {
			tipoAgenda = new vCard();
		}
		
		addContactos(tipoAgenda.readFromFile(file));
	}
	
	public void saveToFile(String file,AgendaFormat tipo) throws IOException{
		tipo.writeToFile(file, agendaArray());
	}
	
	private Pessoa[] agendaArray() {
		return agenda.toArray(new Pessoa[0]);
	}
	
	public int size() {
		return agenda.size();
	}

	@Override
	public String toString() {
		return agenda.toString();
	}
}
