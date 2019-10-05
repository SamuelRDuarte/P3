package Aula8.ex1;

import java.io.IOException;

public class Tabuleiro {
	private char c1,c2;
	private int i = 0;
	char [][] board = new char[3][3];
	
	public static Tabuleiro newTabuleiro(char c) {
		if(c !='O' && c!= 'X')
			return null;
		else
			return new Tabuleiro(c);
	}
	
	private Tabuleiro(char c) {
		c1 = c;
		if(c =='O')
			c2 = 'X';
		if(c == 'X')
			c2 = 'O';
	}
	
	public int jogada(int l,int c) {
		try {
			if(checkEnd() !=-1 || board[l][c] == 'O'|| board[l][c]=='X')
				throw new IOException();
		} catch (IOException e) {
			System.err.println("Erro no programa");
			System.exit(1);
		}
		
		board[l][c] = (i%2 == 0) ? c1:c2;
		i++;
		return checkEnd();
	}
	
	public char getChar(int l,int c) {
		return board[l][c];
	}
	
	
	//1 ou 0 vitoria do jogador1 ou jogador2
	//2 empatado
	//-1 ainda nao acabou
	private int checkEnd() {
		if(checkWin()!=-1) return checkWin();
		if(i == 9) return 2;
		return -1;
	}
	
	private int checkWin() {
		if(board[0][0]==board[1][0] && board[1][0]==board[2][0] && board[0][0] !='\0')
			return i%2;
		if(board[0][1]==board[1][1] && board[1][1]==board[2][1] && board[0][1] !='\0')
			return i%2;
		if(board[0][2]==board[1][2] && board[1][2]==board[2][2] && board[0][2] !='\0')
			return i%2;
		if(board[0][0]==board[0][1] && board[0][1]==board[0][2] && board[0][0] !='\0')
			return i%2;
		if(board[1][0]==board[1][1] && board[1][1]==board[1][2] && board[1][0] !='\0')
			return i%2;
		if(board[2][0]==board[2][1] && board[2][1]==board[2][2] && board[2][0] !='\0')
			return i%2;
		if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0] !='\0')
			return i%2;
		if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2] !='\0')
			return i%2;
		return -1;
	}
}
