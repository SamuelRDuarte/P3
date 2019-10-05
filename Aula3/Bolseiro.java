package Aula3;

public class Bolseiro extends Estudante {
	private int bolsa;

	public Bolseiro(String iNome, int iBI, Data iDataNasc) {
		super(iNome, iBI, iDataNasc);
	}
	
	

	@Override
	public String toString() {
		return super.nome()+", BI: "+super.cc()+", Nasc. Data: "+super.dataNasc()+", NMec: "+super.getMec()+", inscrito em Data: "+super.getDataInsc()
				+", Bolsa: "+bolsa;
	}



	public int bolsa() {
		return bolsa;
	}

	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}
	

}
