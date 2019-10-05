package Aula6.ex1;

import java.util.LinkedList;

public class Prato implements Comparable<Prato> {
	private String nome;
	private LinkedList<Alimento> composicao;
	private double totalCalorias = 0;
	
	public Prato(String nome) {
		super();
		this.nome = nome;
		composicao = new LinkedList<>();
	}

	public String getNome() {
		return nome;
	}

	public double getTotalCalorias() {
		return totalCalorias;
	}
	
	public Alimento[] getAlimentos() {
		return composicao.toArray(new Alimento[0]);
	}
	
	public int getNumAlimentos() {
		return composicao.size();
	}
	
	public boolean contains(Alimento a) {
		return composicao.contains(a);
	}
	
	public boolean addIngrediente(Alimento a) {
		if(a == null) return false;
		composicao.addFirst(a);
		totalCalorias += a.getCalorias();
		return true;
	}
	
	public boolean removeIngrediente(Alimento a) {
		if(a == null) return false;
		composicao.remove(a);
		totalCalorias -= a.getCalorias();
		return true;
	}
	
	public int compareTo(Prato p) {
		return (int) (totalCalorias-p.getTotalCalorias());
	}

	@Override
	public String toString() {
		return "Prato '" + nome + "' composto por " + getNumAlimentos() + " Ingredientes";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCalorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(totalCalorias) != Double.doubleToLongBits(other.totalCalorias))
			return false;
		return true;
	}
	
}
