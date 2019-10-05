package Aula6.ex1;

public enum VariedadeCarne {
	frango,vaca,porco,peru,outra;
	
	public static VariedadeCarne getVarCarne(int v) {
		switch (v) {
		default:
		case 1: return VariedadeCarne.vaca;
		case 2: return VariedadeCarne.porco;
		case 3: return VariedadeCarne.peru;
		case 4: return VariedadeCarne.frango;
		case 5: return VariedadeCarne.outra;
		}
	}
}
