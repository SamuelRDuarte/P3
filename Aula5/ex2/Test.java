package Aula5.ex2;

import Aula5.ex1.UtilCompare;;

public class Test {

	public static void main(String[] args) {
		Veiculo[] veiculos = new Veiculo[9];
		
		Cores azul = Cores.Azul;
		Cores verde = Cores.Verde;
		Cores amarelo = Cores.Amarelo;
		Cores vermelho = Cores.Vermelho;
		
		
		String matricula1 = "FG-27-32";
		String matricula2 = "BE-90-71";
		String matricula3 = "GE-90-36";
		String matricula4 = "66-IO-71";
		String matricula5 = "56-LJ-89";
		String matricula6 = "PP-90-01";
		
		veiculos[0]= new Moto(2000,vermelho,2,1500,120,matricula2,Combustivel.GASOLINA,2.5,40);
		veiculos[1] = new Automovel(2010,azul,4,3000,280, matricula6,Combustivel.DIESEL,4.5,130);
		veiculos[2]= new Bicicleta(2004,amarelo,2);
		
		veiculos[3] = new Moto(2012,vermelho,2,1600,120,matricula1,Combustivel.GASOLINA,3,50);
		veiculos[4]= new Automovel(2014,amarelo,4,3000,280,matricula3,Combustivel.GLP,4,130);
		veiculos[5] = new Bicicleta(2003,verde,2);
		
		veiculos[6] = new CarroPolicia(2016,azul,4,1600,250, matricula4,Combustivel.DIESEL,4.0,120,Tipo.GNR,"GNR-1");
		veiculos[7] = new MotoPolicia(2015,azul,2, 1000,150, matricula5, Combustivel.GASOLINA,2.5,35,Tipo.PSP,"PSP-1");
		veiculos[8]= new BicicletaPolicia(2017,azul,2,Tipo.PJ,"PJ-2");
		
		UtilCompare.sortArray(veiculos);
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo);
		}

	}

}
