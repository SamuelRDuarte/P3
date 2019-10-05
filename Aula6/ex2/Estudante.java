package Aula6.ex2;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataInsc == null) ? 0 : dataInsc.hashCode());
		result = prime * result + mec;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (dataInsc == null) {
			if (other.dataInsc != null)
				return false;
		} else if (!dataInsc.equals(other.dataInsc))
			return false;
		if (mec != other.mec)
			return false;
		return true;
	}
	
	
	
	
}
