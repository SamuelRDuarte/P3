package Aula6.ex2;

import java.util.Calendar;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int d,int m,int a) {
		dia = d;
		mes = m;
		ano = a;
	}
	
	public static boolean validarData(int ano,int mes,int dia) {
		if(ano < 0 || ano >2018) return false;
		if(mes < 1 || mes > 12) return false;
		
		if(mes ==1 || mes ==3|| mes==5||mes==7||mes==8||mes==10 ||mes==12) {
			if(dia<1 || dia >31) return false;
		}
		
		if(mes ==4||mes==6||mes==9||mes==11) {
			if(dia<1 || dia>30) return false;
		}
		if(mes==2) {
			if(bissexto(ano)) {
				if(dia <1 || dia>29) return false;
			}
			if(dia<1 || dia>28) return false; 
		}
		
		return true;
	}
	
	private static boolean bissexto(int ano){
		return ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0);
	}
	
	public String toString() {
		return dia+"/"+mes+"/"+ ano;
	}
	
	public int getIdade(){
		Calendar now = Calendar.getInstance();
		int dyear = now.get(Calendar.YEAR)-this.ano;
		if(now.get(Calendar.MONTH)<this.mes) return dyear;
		else if(now.get(Calendar.MONTH)>this.mes) return dyear-1;
		else{
			if(now.get(Calendar.DAY_OF_MONTH)<=this.dia) return dyear;
			else return dyear-1;
		}
		
	}
	
	public static Data getDataToday(){
		Calendar now = Calendar.getInstance();
		int dia = now.get(Calendar.DAY_OF_MONTH);
		int mes = now.get(Calendar.MONTH)+1;
		int ano = now.get(Calendar.YEAR);
		return new Data(dia,mes,ano);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (ano != other.ano)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}
	
	
	

}
