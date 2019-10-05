package ap2018;
import java.util.*;
import java.util.stream.Collectors;

public class Feira {
	private String nome;
	private String local;
	private Set<Stand> stands;
	private Set<Visitante> visitantes;
	
	public Feira(String nome, String local) {
		this.nome = nome;
		this.local = local;
		stands = new HashSet<>();
		visitantes = new HashSet<>();
	}
	
	public String getNome() {
		return nome;
	}


	public String getLocal() {
		return local;
	}


	public Set<Stand> getStands() {
		return stands;
	}


	public Set<Visitante> getVisitantes() {
		return visitantes;
	}


	public void add(Stand s) {
		stands.add(s);
	}
	
	public void add(Visitante v) {
		visitantes.add(v);
	}
	
	public String emailsDosResponsaveis(){
		List<String> emails = new ArrayList<>();
		
		stands.forEach(s->emails.add(s.responsavel().getEmail()));
		return emails.toString();
	}
	
	public String visitantesEntreDatas(String di,String df) {
		int mini = Integer.parseInt(di.split(":")[2]);
		int minf = Integer.parseInt(df.split(":")[2]);
		List<Visitante> tmp = new ArrayList<>();
		for (Visitante visitante : visitantes) {
			int min = Integer.parseInt(visitante.getEntrada().split(":")[2]);
			if(min>=mini && min<=minf)
				tmp.add(visitante);
		}
		return tmp.toString();
	}
	
	public String getServico(Servico t) {
		return stands.stream().filter(s->s.getServico()==t).collect(Collectors.toList()).toString();
	}

	@Override
	public String toString() {
		return  nome + "- Total de Expositores:" + stands.size() + "; Total de visitantes=" + visitantes.size();
	}
	
	

}
