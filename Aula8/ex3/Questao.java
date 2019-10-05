package Aula8.ex3;

public class Questao implements Comparable<Questao>{
	
	private String imgPath,pergunta,resposta;
	private String[] opçoes;
	private int dificuldade,premio;
	
	public Questao(String imgPath, String pergunta, String resposta, int dificuldade, String... opçoes) {
		this.imgPath = imgPath;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.opçoes = Info.scrambleArray(opçoes);
		this.dificuldade = dificuldade;
	}

	public String getImgPath() {
		return "C:\\\\Users\\\\samue\\\\OneDrive - Universidade de Aveiro\\\\Universidade\\\\2Ano\\\\P3\\\\aula8_material\\\\aula8_material\\\\QQSM\\\\"+imgPath;
	}

	public String getPergunta() {
		return pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public String[] getOpçoes() {
		return opçoes;
	}
	
	public String getOpçao(int index) {
		return opçoes[index];
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	@Override
	public int compareTo(Questao q) {
		return this.dificuldade < q.dificuldade ? -1:(this.dificuldade == q.dificuldade ? 0:1);
	}
	
	
	

}
