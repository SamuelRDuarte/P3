package Aula3.ex4;

import java.text.*;
import java.util.Date;

public class Data {
	private int dia,mes,ano;
	
	public Data(int dia, int mes, int ano) {
		if(!isvalid(dia,mes,ano)) throw new IllegalArgumentException("Data invalida");
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getAno() {
		return ano;
	}

	private static boolean isvalid(int d,int m,int a) {
		Date date = null;
		String input = d+"-"+m+"-"+a;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			format.setLenient(false);
			date = format.parse(input);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
