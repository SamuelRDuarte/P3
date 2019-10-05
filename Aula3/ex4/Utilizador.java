package Aula3.ex4;

import java.util.*;

public class Utilizador {
	private String nome;
	private int cc;
	private Data dataNasc;
	private List<Video> watchedVideos;
	private List<Video> videoHistory;
	
	public Utilizador(String nome, int cc, Data dateNasc) {
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dateNasc;
		watchedVideos = new ArrayList<>();
		videoHistory = new ArrayList<>();
	}
	
	public void lendVideoToUser(Video v) {
		watchedVideos.add(v);
		videoHistory.add(v);
	}
	
	public void returnVideoFromUser(Video v) {watchedVideos.remove(v);}

	public String getNome() {
		return nome;
	}
	public int getCc() {
		return cc;
	}
	public Data getDateNasc() {
		return dataNasc;
	}	
	public Video[] watchedVideosToArray() {
		return watchedVideos.toArray(new Video[0]);
	}
	public Video[] videoHistoryToArray() {
		return videoHistory.toArray(new Video[0]);
	}
	public String toString() { return nome + "|" + cc + "|" + dataNasc.toString(); }
	public int numberOfVideosOwned() { return watchedVideos.size(); }

}
