package Aula2;

public class Video {
	
	private static int id = 1;
	private int ID;
	private String titulo;
	private String categoria;
	private String idade;
	private boolean disponivel;
	private Clientes[] cl = new Clientes[0];
	private static int num=0;
	private double rating =0;
	
	public Video(String titulo, String categoria, String idade) {
		
		ID = id++;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
		disponivel = true;
	}
	
	public int getID() {
		return ID;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getIdade() {
		return idade;
	}
	
	public boolean isAvailable() {
		return disponivel;
	}
	
	public void checkout(Clientes x) {
		addLoanName(x);
		disponivel = false;
		x.addVid(this);
	}	
	private void addLoanName(Clientes x) {
		Clientes[] c = new Clientes[cl.length+1];
		for(int i=0;i<cl.length;i++) {
			c[i]= cl[i];
		}
		c[cl.length]= x;
		cl = c;
	}
		
	public Clientes[] getLoanHist() {
		return cl;
	}

	public void checkin(double rat) {
		disponivel = true;
		num++;
		this.rating += rat;
	}
	
	public double ratMed() {
		if(num !=0)
			return rating/num;
		else return 0;
	}
	
	
	@Override
	public String toString() {
		return "Video [ID=" + ID + ", titulo=" + titulo + ", categoria=" + categoria + ", idade=" + idade
				+ ", disponivel=" + disponivel + ", ratMed()=" + ratMed() + "]";
	}

	
	public  static boolean idadeValida(String age) {
		return age.equals("ALL") || age.equals("M6") || age.equals("M12") || age.equals("M16") || age.equals("M18");
	}
}
