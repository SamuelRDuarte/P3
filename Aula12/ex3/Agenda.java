package Aula12.ex3;

import java.io.*;
import java.util.*;


abstract class PluginManager {
	public static Plugin load(String name) throws Exception {
		Class<?> c = Class.forName(name);
		return (Plugin) c.newInstance();
	}
}

public class Agenda {
	
	private List<Pessoa> agenda = new ArrayList<>();
	private List<Plugin> plugins = new ArrayList<>();
	
	public Agenda() throws Exception {
		loadPlugins("C:\\Users\\samue\\OneDrive - Universidade de Aveiro\\Universidade\\2Ano\\P3\\P3_Alulas\\src\\Aula12\\ex3\\plugins");
	}
	
	public void loadPlugins(String directoryName) throws Exception {
		for(File pf : (new File(directoryName)).listFiles()) {
			String pluginName = "aula12.ex3.plugins."+pf.getName().split("\\.")[0];
			plugins.add(PluginManager.load(pluginName));
		}
	}
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
	
	public void loadFromFile(String file) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Scanner scf = new Scanner(new File(file));
		Plugin pluginProxy = (Plugin)Class.forName("Aula12.ex3."+scf.nextLine()).newInstance();
		scf.close();
		addContactos(pluginProxy.readFromFile(file));
	}
	
	public void saveToFile(String file,Plugin tipo) throws IOException{
		tipo.writeToFile(file, agendaArray());
	}
	
	public List<Plugin> supportedPlugins(){
		return plugins;
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
