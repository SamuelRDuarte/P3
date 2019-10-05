package Aula04;


public class Disciplina {
	
	private String disciplina;
	private String areaCientifica;
	private int ects;
	private Professor responsavel;
	private Estudante[] alunos;
	
	public Disciplina(String disciplina, String areaCientifica, int ects, Professor responsavel) {
		this.disciplina = disciplina;
		this.areaCientifica = areaCientifica;
		this.ects = ects;
		this.responsavel = responsavel;
		alunos = new Estudante[0];
	}

	public String getDisciplina() {
		return disciplina;
	}

	public String getAreaCientifica() {
		return areaCientifica;
	}

	public int getEcts() {
		return ects;
	}

	public Professor getResponsavel() {
		return responsavel;
	}
		
	public Estudante[] getAlunos() {
		return alunos;
	}
	
	public Estudante[] getAlunos(String tipo) {
		Estudante[] tipoAlunos = new Estudante[0];
		for(int i = 0;i< alunos.length;i++) {
			if(alunos[i].getClass().getSimpleName().equals(tipo))
				tipoAlunos =addEst(tipoAlunos,alunos[i]);
		}
		return tipoAlunos;
	}
	
	private Estudante[] addEst(Estudante[] array,Estudante novo) {
		Estudante[] c = new Estudante[array.length+1];
		for(int i = 0;i<array.length;i++) {
			c[i] = array[i];
		}
		c[array.length] = novo;
		return c;
		
	}
	

	public boolean addAluno(Estudante est) {
		Estudante[] c = new Estudante[alunos.length+1];
		
		if(alunoInscrito(est.getMec()))
			return false;
		else {
			for(int i = 0;i<alunos.length;i++) {
				c[i] = alunos[i];
			}
			c[alunos.length] = est;
			alunos = c;
			return true;
		}	
		
	}
	
	public boolean delAluno(int nMec) {
		Estudante[] c = new Estudante[alunos.length-1];
		int j = 0;
		if(!alunoInscrito(nMec)) return false;
		for(int i = 0; i<alunos.length;i++) {
			if(!(alunos[i].getMec() == nMec))
				c[j++] = alunos[i];
		}
		alunos = c;
		return true;
	}
	
	public boolean alunoInscrito(int nMec) {
		for(Estudante e: alunos) {
			if(e.getMec() == nMec)
				return true;
		}
		return false;
	}
	
	public int numAlunos() {
		return alunos.length;
	}

	@Override
	public String toString() {
		return "Disciplina: " + disciplina+" ("+ects+" ECTS) da Area de "+areaCientifica+"\n"
				+"Responsavel: "+responsavel+"\n"
				+"Existem "+numAlunos()+" Alunos Inscritos";
	}

}
