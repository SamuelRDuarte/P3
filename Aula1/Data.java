package Aula1;


public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int d,int m,int a) {
		dia = d;
		mes = m;
		ano = a;
	}
	
	public boolean validarData() {
		if(ano < 0 || ano >2018) return false;
		if(mes < 1 || mes > 12) return false;
		
		if(mes ==1 || mes ==3|| mes==5||mes==7||mes==8||mes==10 ||mes==12) {
			if(dia<1 || dia >31) return false;
		}
		
		if(mes ==4||mes==6||mes==9||mes==11) {
			if(dia<1 || dia>30) return false;
		}
		if(mes==2) {
			if(bissexto()) {
				if(dia <1 || dia>29) return false;
			}
			if(dia<1 || dia>28) return false; 
		}
		
		return true;
	}
	
	private boolean bissexto(){
		return ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0);
	}
	
	public String toString() {
		return dia+"/"+mes+"/"+ ano;
	}
	

}
