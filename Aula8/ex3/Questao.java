package Aula8.ex3;

public class Questao implements Comparable<Questao>{
	
	private String imgPath,pergunta,resposta;
	private String[] op�oes;
	private int dificuldade,premio;
	
	public Questao(String imgPath, String pergunta, String resposta, int dificuldade, String... op�oes) {
		this.imgPath = imgPath;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.op�oes = Info.scrambleArray(op�oes);
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

	public String[] getOp�oes() {
		return op�oes;
	}
	
	public String getOp�ao(int index) {
		return op�oes[index];
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
