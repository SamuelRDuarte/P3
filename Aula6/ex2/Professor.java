package Aula6.ex2;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result + nfunc;
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
		Professor other = (Professor) obj;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (nfunc != other.nfunc)
			return false;
		return true;
	}
	
	

	
	
	
	
	
	

}
