package Aula2;

import java.util.*;
import static java.lang.System.*;

public class VideoClube {
	
	static Scanner sc = new Scanner(in);
	private Clientes[] cl = new Clientes[0];
	private Video[] vid = new Video[0];
	private int quotas;
	
	
	public VideoClube(int quotas) {
		this.quotas = quotas;
	}
	
	public Clientes[] getClients() {
		return cl;
	}
	public Video[] getVid() {
		return vid;
	}
	public int getQuotas() {
		return quotas;
	}
	
	
	public void addFunc(){
		Clientes[] c = new Clientes[cl.length+1];
		for(int i =0;i<cl.length;i++) {
			c[i]= cl[i];
		}
		
		out.print("\nNome do cliente: ");
		String nome = sc.nextLine();
		sc.nextLine();

		int ano = 0,mes=0,dia=0;
		
		do {
			out.print("\nInsira o seu ano de nascimento: ");
			ano = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu mês de nascimento: ");
			mes = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu dia de nascimento: ");
			dia = sc.nextInt();
			
			if(!Data.validarData(ano, mes, dia)) out.print("\nData inválida!");

		}while(!Data.validarData(ano,mes,dia));
		
		Data nasc = new Data(dia,mes,ano);
		
		int cc;
		
		do {
			out.print("\nInsira o seu número de CC: ");
			cc = sc.nextInt();
			sc.nextLine();
			if(cc<0) out.print("\nNúmero de CC inválido!");
		}while(cc < 0);
		
		int x;
		do {
			out.print("\nEstudante(1) ou Funcionario(2): ");
			z = sc.nextInt();
		} while (x!=1 && x!=2);
		
		if(x==2) {
			int nFunc,nif;
		
			do{
				out.print("\nInsira o seu número de funcionário: ");
				nFunc = sc.nextInt();
				sc.nextLine();
				if(nFunc<0) out.print("\nNúmero de funcionário inválido!");
			}while(nFunc<0);
			
			do{
				out.print("\nInsira o seu número fiscal: ");
				nif = sc.nextInt();
				sc.nextLine();
				if(nif<0) out.print("\nNúmero fiscal inválido!");
			}while(nif<0);
			
			c[cl.length]= new Funcionario(cc,nome,nasc,nFunc,nif,quotas);
			cl = c;
			out.println("\nFuncionário criado com sucesso com o número de sócio "+c[cl.length-1].getnSocio()+" !");
		}else {
			int nmec;
			
			do{
				out.print("\nInsira o seu número mecanográfico: ");
				nmec = sc.nextInt();
				sc.nextLine();
				if(nmec<0) out.print("\nNúmero mecanográfico inválido!");
			}while(nmec<0);
			
			out.print("\nInsira o nome do seu curso: ");
			String curso = sc.nextLine();
			
			c[cl.length] = new Estudante(cc,nome,nasc,nmec,curso,quotas);
			cl = c;
			out.println("\nFuncionário criado com sucesso com o número de sócio "+c[cl.length-1].getnSocio()+" !");
			
		}

	}
		
	public void dellFunc() {
		out.print("\nNumero de socio: ");
		int num = sc.nextInt();
		int p = searchFunc(num);
		if(p == -1) out.print("\nO cliente nao existe");
		else {
			func[p] = null;
			out.print("\nCliente removido com sucesso");
		}
	}
	
	public void dellEst() {
		out.print("\nNumero de socio: ");
		int num = sc.nextInt();
		int p = searchEst(num);
		if(p == -1) out.print("\nO cliente nao existe");
		else {
			est[p] = null;
			out.print("\nCliente removido com sucesso");
		}
	}
	
	public void addVid() {
		Video[] c = new Video[vid.length+1];
		for(int i=0;i<vid.length;i++) {
			c[i]= vid[i];
		}
		
		out.print("\nNome do video: ");
		String nome = sc.nextLine();
		
		out.print("Categoria: ");
		String cat = sc.nextLine();
		
		String idade;
		do {
			out.print("\nIdade minima: ");
			idade = sc.nextLine();
			if(!Video.idadeValida(idade)) {
				out.print("\nIdade invalida");
			}
		}while(!Video.idadeValida(idade));
		
		c[vid.length]= new Video(nome,cat,idade);
		vid = c;
		out.print("\n O video foi criado com sucesso com ID "+c[c.length-1].getID());
	}
	
	public void delVid(){
		out.print("\nInsira o ID do video a apagar:");
		int id = sc.nextInt();
		int p = searchVid(id);
		if(p == -1) out.print("\nO video nao existe");
		else {
			vid[p]= null;
			out.print("\nVideo removido com sucesso");
		}
	}
	
	public void pesVid() {
		out.print("\nNome do video a procurar: ");
		String nome = sc.nextLine();
		out.print("\nVideos encontrados:");
		for(Video a: vid) {
			if(a!= null && a.getTitulo().contains(nome)) {
				out.print("\n"+a.toString());
			}
		}
	}
	
	public void vidByCl(){
		out.print("\nNumero de socio: ");
		int nsoc= sc.nextInt();
		
		int idade = -1;
		
		int p = searchEst(nsoc);
		if(p==-1) p=searchFunc(nsoc);
		else if(p != -1) {
			idade = est[p].getDataNasc().getIdade();
		}
		if(p==-1) out.print("\nNao existe ninguem esse numero de socio");
		else{
			if(idade == -1) idade = func[p].getDataNasc().getIdade();
			
			out.print("\nVideos disponiveis");
			
			for(Video a :vid){
				if(a != null){
					if(a.getIdade().equals("ALL") & a.isAvailable())
						out.print("\n"+a.toString());
					else if(a.getIdade().equals("M6") & a.isAvailable() & idade >6)
						out.print("\n"+a.toString());
					else if(a.getIdade().equals("M12") & a.isAvailable() & idade >12)
						out.print("\n"+a.toString());
					else if(a.getIdade().equals("M16") & a.isAvailable() & idade >16)
						out.print("\n"+a.toString());
					else if(a.getIdade().equals("M18") & a.isAvailable() & idade >18)
						out.print("\n"+a.toString());
				}
			}
		}
	}
	
	public void loan() {
		out.print("\nInsira o ID no video:");
		int id = sc.nextInt();
		
		int p = searchVid(id);
		
		if(p==-1) out.print("\nO video nao existe");
		else {
			if(!vid[p].isAvailable()) out.print("\nO video esta emprestado");
			else{
				int a = addCl();
				int p2;
				if(a==1){
					out.print("\nNumero de socio do estudante:");
					int nsoc= sc.nextInt();
					p2 = searchEst(nsoc);
					if(p2==-1) {
						out.print("\nO cliente nao existe");
						return;
					}else if(est[p2].getQuotasLeft()==0){
						out.print("\nO utilizar excedeu o limite de quotas para requisitar videos");
						return;
					}else{
						int idade = est[p2].getDataNasc().getIdade();
						if(vid[p].getIdade().equals("ALL") && vid[p].isAvailable())
							vid[p].checkout(est[p2]);
						else if(vid[p].getIdade().equals("M6") && vid[p].isAvailable() && idade>6)
							vid[p].checkout(est[p2]);	
						else if(vid[p].getIdade().equals("M12") && vid[p].isAvailable() && idade>12)
							vid[p].checkout(est[p2]);
						else if(vid[p].getIdade().equals("M16") && vid[p].isAvailable() && idade>16)
							vid[p].checkout(est[p2]);
						else if(vid[p].getIdade().equals("M18") && vid[p].isAvailable() && idade>18)
							vid[p].checkout(est[p2]);
						else{
							out.print("\nO video nao pode ser emprestado");
							return;
						}
					}
					
				}else{
					out.print("\nNumero de socio do funcionario: ");
					int nsoc = sc.nextInt();
					p2 = searchFunc(nsoc);
					if(p2==-1) {
						out.print("\nO cliente nao existe");
						return;
					}else if(func[p2].getQuotasLeft()==0){
						out.print("\nO utilizar excedeu o limite de quotas para requisitar videos");
						return;
					}else{
						int idade = func[p2].getDataNasc().getIdade();
						if(vid[p].getIdade().equals("ALL") && vid[p].isAvailable())
							vid[p].checkout(func[p2]);
						else if(vid[p].getIdade().equals("M6") && vid[p].isAvailable() && idade>6)
							vid[p].checkout(func[p2]);	
						else if(vid[p].getIdade().equals("M12") && vid[p].isAvailable() && idade>12)
							vid[p].checkout(func[p2]);
						else if(vid[p].getIdade().equals("M16") && vid[p].isAvailable() && idade>16)
							vid[p].checkout(func[p2]);
						else if(vid[p].getIdade().equals("M18") && vid[p].isAvailable() && idade>18)
							vid[p].checkout(func[p2]);
						else{
							out.print("\nO video nao pode ser emprestado");
							return;
						}
					}
					
				}
			}
		}
		out.print("\nO video emprestado com sucesso");
	}
	
	public void checkLoan() {
		out.print("\nInsira o ID do video: ");
		int id = sc.nextInt();
		
		int p = searchVid(id);
		
		if(p == -1) out.print("O video nao existe");
		else {
			if(vid[p].isAvailable())
				out.print("\nO video esta disponivel");
			else
				out.print("\nO video esta indisponivel");
		}
	}
	
	public void devVid() {
		out.print("\nInsira o ID do video: ");
		int id = sc.nextInt();
		
		int p = searchVid(id);
		if(p == -1) out.print("O video nao existe");
		else if(vid[p].isAvailable())
			out.print("\nO video ja foi entregue");
		else {
			double rat;
			do {
				out.print("\nRating do video(0-10): ");
				rat = sc.nextDouble();
				if(rat<0 || rat>10)
					out.print("\nRating invalido");
			}while(rat<0 || rat>10);
			vid[p].checkin(rat);
			out.print("\nO video foi entregue com sucesso");
		}
	}
	
	public void userReq() {
		out.print("\nInsira o ID do video: ");
		int id = sc.nextInt();
		
		int p = searchVid(id);
		if(p == -1) {
			out.print("O video nao existe");
		}else{
			for(Funcionario a: vid[p].getLoanFuncHist()) {
				if(a!=null)
					out.print("\n"+a.toString());
			}
			for(Estudante a: vid[p].getLoanEstHist()) {
				if(a!=null) {
					out.print("\n"+a.toString());
				}
			}
		}
	}
	
	public void listRat() {
		boolean troca;
		int f = vid.length;
		do {
			troca = false;
			for(int i = 0;i<f;i++) {
				if(vid[i].ratMed()<vid[i+1].ratMed()) {
					Video tmp = vid[i];
					vid[i]= vid[i+1];
					vid[i+1]= tmp;
					troca = true;
				}
				f--;
			}
			for(Video a:vid) {
				if(a != null)
					out.print("\n"+a.toString());
			}
		}while(troca);
	}
	
	public void lisVidEst() {
		out.print("\nInsira o numero de socio do estudante: ");
		int nsoc = sc.nextInt();
		sc.nextLine();
		int p = searchEst(nsoc);
		if(p==-1) out.print("\nO estudante nao existe");
		else {
			Video[] v = est[p].getVid();
			out.print("\nO cliente requisitou:");
			for(Video a : v) {
				if(a!=null) out.print("\n"+a.toString());
			}
		}
	}
	
	public void lisVidFunc() {
		out.print("\nInsira o numero de socio do funcionario: ");
		int nsoc = sc.nextInt();
		sc.nextLine();
		int p = searchFunc(nsoc);
		if(p==-1) out.print("\nO funcionario nao existe");
		else {
			Video[] v = func[p].getVid();
			out.print("\nO cliente requisitou:");
			for(Video a : v) {
				if(a!=null) out.print("\n"+a.toString());
			}
		}
	}
	
	
	
	
	
	private int searchEst(int n) {
		for(int i = 0;i<est.length;i++) {
			if(est[i]!= null && est[i].getnSocio() == n) {
				return i;
			}
		}
		return -1;
	}
	
	private int searchFunc(int n) {
		for(int i = 0;i<func.length;i++) {
			if(func[i]!= null && func[i].getnSocio() == n) {
				return i;
			}
		}
		return -1;
	}
	
	private int searchVid(int n) {
		for(int i = 0;i<vid.length;i++) {
			if(vid[i]!= null && vid[i].getID() == n) {
				return i;
			}
		}
		return -1;
	}
	
	

}
