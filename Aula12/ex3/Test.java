package Aula12.ex3;


import Aula12.ex3.plugins.*;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Agenda agenda = new Agenda();
		System.out.println("Supported plugins: ");
		agenda.supportedPlugins().forEach(System.out::println);
		System.out.println();
		
		//Nokia format
		agenda.loadFromFile("C:/Users/samue/OneDrive - Universidade de Aveiro/Universidade/2Ano/P3/P3_Alulas/src/Aula5/ex3/File1.txt");
		agenda.addContacto(new Pessoa("Manuel",new Data(17,02,1999),962789374));
		agenda.addContacto(new Pessoa("André",new Data(11,03,1993),968231312));
		agenda.saveToFile("OutputFile1.txt", new Nokia());
		System.out.println("A agenda #1 tem "+agenda.size()+" contactos:");
		System.out.println(agenda);
		System.out.println();
		
		//vCard format
		agenda = new Agenda();agenda.loadFromFile("C:/Users/samue/OneDrive - Universidade de Aveiro/Universidade/2Ano/P3/P3_Alulas/src/Aula5/ex3/File2.txt");
		agenda.addContactos(new Pessoa[] {
				new Pessoa("João",new Data(12,12,2001),931231322),
				new Pessoa("Rui",new Data(14,11,2002),968222312),
				new Pessoa("Luis",new Data(03,05,1995),968231312),
		});
		agenda.addContacto(new Pessoa("Mariana",new Data(19,07,1999),962765474));
		agenda.saveToFile("OutputFile2.txt",new vCard());
		System.out.println("A agenda #2 tem "+agenda.size()+" contactos:");
		System.out.println(agenda);
		System.out.println();
		
		//CSV format
		agenda = new Agenda();
		agenda.loadFromFile("C:/Users/samue/OneDrive - Universidade de Aveiro/Universidade/2Ano/P3/P3_Alulas/src/Aula5/ex3/File3.txt");
		agenda.addContacto(new Pessoa("Ana",new Data(12,9,1997),962222374));
		agenda.addContacto(new Pessoa("Nuno",new Data(16,05,2000),962282374));
		agenda.saveToFile("OutputFile3.txt", new CSV());
		System.out.println("A agenda #3 tem "+agenda.size()+" contactos:");
		System.out.println(agenda);
		System.out.println();

	}

}
