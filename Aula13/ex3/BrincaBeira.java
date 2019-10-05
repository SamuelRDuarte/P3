package Aula13.ex3;

import java.util.Arrays;

public class BrincaBeira {

	public static void main(String[] args) {
		
		/* These string[] are used for testing purposes */
		String[] workers = {"Andre Mourato", "Manuel Silva", "Joao Martins", "Tiago Ferreira",
				"Joana Veiga", "Ana Marques","Tatiana Sousa", "Marco Oliveira",
				"Juliana Pereira", "Fabio Antunes", "Marcelo Frafa", "Miguel Costalini",
				"Andre Alves", "Fabio Ribeiro", "Joana Soares", "Miguel Muralha", "Andre Moreira"};
		String[] toys = {"Carro", "Comboio a vapor", "Power Ranger Amarelo", "LEGO City", 
					"Bola de futebol","Darth Vader - Boneco de Ação"};
		
		System.out.println("------ Testing RegistoNomes ------");
		
		RegistoNomes nomes = new RegistoNomes();
		Arrays.stream(workers).forEach(x-> nomes.addFuncionario(x));
		System.out.println(nomes);
		System.out.println(nomes.removeFuncionario("c") ? "Removed c!" : "Failed to remove c"); //true
		System.out.println(nomes.removeFuncionario("p") ? "Removed p!" : "Failed to remove p!");//falso
		
		System.out.println("\n------ Testing GiftEmpregado ------");
		
		GiftEmpregado prendas = new GiftEmpregado();
		for (int i = 0; i < 12; i++) {
			int randempregado = (int) (Math.random()*workers.length);
			int randGift = (int) (Math.random()*toys.length);
			prendas.oferecer(toys[randGift], workers[randempregado]);
		}
		System.out.println("\nList of gifts...\n");
		System.out.println(prendas);
		for(String worker : workers) {
			System.out.println(prendas.removeGift(worker) ? "Removed gift from "+worker : worker+" doesn't have a present");
		}
		System.out.println("\nList of gifts...\n");
		System.out.println(prendas);
		
		System.out.println("\n------ Testing ToyList ------");
		String randomWorker = workers[(int)(Math.random() * workers.length)];
		ToysList toyList = new ToysList(randomWorker);
		//Adds all toys
		Arrays.stream(toys).forEach(x -> toyList.add(x));
		System.out.println(toyList);
		toyList.setNome("Samuel Duarte");
		System.out.println(toyList);
		System.out.println(toyList.remove("Carro") ? "Removed Carro!" : "Could not remove Carro");
		System.out.println(toyList.remove("Barbie") ? "Removed Barbie!" : "Could not remove Barbie");
		
		System.out.println("\n------ Testing Name Counter ------");
		NumFuncionarios counter = new NumFuncionarios();
		//Counts names
		Arrays.stream(workers).forEach(x -> counter.insert(x));
		System.out.println(counter);
		counter.remove("Andre"); //decrements by 1 the number of names Andre
		counter.remove("Joana"); //and so on...
		counter.remove("Joana");
		System.out.println(counter);
		
		
		System.out.println("\n------ Testing Ticket Manager ------\n");
		
		Bilhetes manager = new Bilhetes(workers);
		System.out.println("Given tickets to: \n");
		manager.giveBilhetes(4).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.giveBilhetes(3).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		manager.giveBilhetes(1).forEach(System.out::println);
		System.out.println("\nGiven tickets to: \n");
		//Will rotate and give a ticket to the first worker
		manager.giveBilhetes(18).forEach(System.out::println);
	}

}
