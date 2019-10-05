package Aula5.ex1;

public class UtilCompare {
	
	public static Comparable findMax(Comparable[] lista) {
		int index = 0;
		for (int i = 1; i < lista.length; i++) {
			if (lista[i].compareTo(lista[index])>0) {
				index = i;
				
			}
		}
		return lista[index];
	}
	
	public static void sortArray(Comparable[] lista) {
		boolean troca = true;
		Comparable tmp;
		do {
			troca = false;
			for (int i = 0; i < lista.length-1; i++) {
				if (lista[i].compareTo(lista[i+1])>0) {
					tmp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1]=tmp;
					troca = true;
				}
			}
		} while (troca);
	}
	

}
