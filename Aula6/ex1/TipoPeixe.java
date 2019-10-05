package Aula6.ex1;

public enum TipoPeixe {
	congelado,fresco;

	public static TipoPeixe getTipo(int v) {
		switch (v) {
		default:
		case 1: return TipoPeixe.congelado;
		case 2: return TipoPeixe.fresco;
		}
	}
}
