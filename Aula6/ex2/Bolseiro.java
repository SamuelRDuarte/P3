package Aula6.ex2;

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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bolsa;
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
		Bolseiro other = (Bolseiro) obj;
		if (bolsa != other.bolsa)
			return false;
		return true;
	}
	
	
	

}
