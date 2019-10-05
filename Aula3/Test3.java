package Aula3;

import static java.lang.System.*;

public class Test3 {

	public static void main(String[] args) throws IllegalAccessException {
		
		try {

			Pessoa p = new Pessoa("c3",1,new Data(01,02,2000));
			Condutor c1 = new Condutor("c1",1,new Data(01,02,2000),"A");
			Condutor c2 = new Condutor("c2",1,new Data(01,02,2000),"B");
			Condutor c3 = new Condutor("c3",1,new Data(01,02,2000),"C");
			Condutor c4 = new Condutor("c1",1,new Data(01,02,2000),"D");
			Condutor c5 = new Condutor("B",p);
			Condutor c6 = new Condutor(c1);
			
			out.println("\nTestes dos Condutores:");
			out.println("c1 equals to p? -> "+c1.equals(p));  //false
			out.println("c1 equals to c4? -> "+c1.equals(c4)); //false
			out.println("c2 equals to c3? -> "+c2.equals(c3)); //false
			out.println("c1 equals to c6? -> "+c1.equals(c6)); //True
			out.println("c2 equals to c5? -> "+c2.equals(c5)); //True

			Motociclo m1 = new Motociclo(1,2,2,"A",10);
			Motociclo m2 = new Motociclo(m1);
			Ligeiro l1 = new Ligeiro(10,20,5,"B",40);
			Ligeiro l2 = new Ligeiro(10,20,5,"B",45);
			PesadoMercadorias pm = new PesadoMercadorias(14,34,3,"C",56);
			PesadoPessoas pp = new PesadoPessoas(13,30,15,"D",54);
			
			out.println("\nVeiculos:");
			out.println(m1);
			out.println(m2);
			out.println(l1);
			out.println(l2);
			out.println(pm);
			out.println(pp);
			
			out.println("\nTestes dos veiculos:");
			out.println("m1 equals to m2? -> " + m1.equals(m2)); // True
			out.println("l1 equals to l2? -> " + l1.equals(l2)); // False
			out.println("pp equals to pm? -> " + pp.equals(pm)); // False

			
			out.println("\nTestes dos condutores e veiculos:");
			out.println("c1 can drive v1? -> " + m2.canDrive(c1)); // True
			out.println("c1 can drive l2? -> " + l2.canDrive(c1)); // False
			out.println("c4 can drive pp? -> " + pp.canDrive(c4)); // True
			out.println("c4 can drive pm? -> " + pm.canDrive(c4)); // True
			out.println("c2 can drive pp? -> " + pp.canDrive(c2)); // False

			
		}catch(IllegalAccessException e){
			out.println("Nao pode conduzir");
		}
		catch (IllegalArgumentException e) {
			out.println("Carta Invalida");
		}
		
	}

}
