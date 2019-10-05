package Aula04;

public class Professor extends Pessoa {
	private static int num = 1;
	private int nfunc;
	private Data dataAdmissao;
	
	public Professor(String n, int c, Data d) {
		super(n, c, d);
		this.nfunc = num++;
		this.dataAdmissao = Data.getDataToday();
	}

	public int getNfunc() {
		return nfunc;
	}

	public Data getDataAdmissao() {
		return dataAdmissao;
	}

	@Override
	public String toString() {
		return "Professor: "+super.nome()+", BI: "+super.cc()+", Nascido na Data: "+super.dataNasc()+", NMec: "+nfunc+", Admitido em Data: "+dataAdmissao;
	}
	
	

	
	
	
	
	
	

}
