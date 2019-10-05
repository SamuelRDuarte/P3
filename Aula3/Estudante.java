package Aula3;

public class Estudante extends Pessoa {
	
	private int mec;
	private static int num = 100;
	private Data dataInsc;
	
	
	
	public Estudante(String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
		super(iNome, iBI, iDataNasc);
		this.mec = num++;
		this.dataInsc = iDataInsc;
	}
	
	
	public Estudante(String iNome, int iBI, Data iDataNasc) {
		super(iNome, iBI, iDataNasc);
		this.mec = num++;
		this.dataInsc = Data.getDataToday();
	}


	public int getMec() {
		return mec;
	}
	public Data getDataInsc() {
		return dataInsc;
	}


	@Override
	public String toString() {
		return super.nome()+", BI: "+super.cc()+", Nasc. Data: "+super.dataNasc()+", NMec: "+mec+", inscrito em Data: "+dataInsc;
	}
	
	
	
}
