package Aula8.ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoDoGalo extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JToggleButton[] botoes = new JToggleButton[9];
	Tabuleiro jogo;

	public static void main(String[] args) {
		new JogoDoGalo(new String[] {"X"} );
	}
	
	public JogoDoGalo(String args[]){
		super("Jogo do Galo");
		jogo = Tabuleiro.newTabuleiro(args[0].toCharArray()[0]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		
		JPanel conteudo = (JPanel) this.getContentPane();
		conteudo.setBackground(Color.WHITE);
		conteudo.setLayout(new GridLayout(3,3));
		
		for (int i = 0; i < 9; i++) {
			botoes[i] = new JToggleButton();
			botoes[i].addActionListener(this);
			conteudo.add(botoes[i]);
		}
		setContentPane(conteudo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x,y;
		x = ((JToggleButton)e.getSource()).getX();
		y = ((JToggleButton)e.getSource()).getY();
		
		for (int i = 0; i < botoes.length; i++) {
			if(e.getSource() == botoes[i]) {
				switch (i) {
				case 0:
					x = 0;
					y = 0;
					break;
				case 1:
					x = 0;
					y = 1;
					break;
				case 2:
					x = 0;
					y = 2;
					break;
				case 3:
					x = 1;
					y = 0;
					break;
				case 4:
					x = 1;
					y = 1;
					break;
				case 5:
					x = 1;
					y = 2;
					break;
				case 6:
					x = 2;
					y = 0;
					break;
				case 7:
					x = 2;
					y = 1;
					break;
				case 8:
					x = 2;
					y = 2;
					break;
				}
				break;
			}	
		}
		
		int a = jogo.jogada(x, y);
		
		((JToggleButton)e.getSource()).setText(String.valueOf(jogo.getChar(x, y)));
		((JToggleButton)e.getSource()).setFont(new Font("Arial",Font.PLAIN,30));
		((JToggleButton)e.getSource()).setVerticalTextPosition(SwingConstants.CENTER);
		((JToggleButton)e.getSource()).setHorizontalTextPosition(SwingConstants.CENTER);
		
		if(a == 2) {
			JOptionPane.showMessageDialog(this.getContentPane(),"Empate");
			System.exit(0);
		}
		if(a == 0) {
			JOptionPane.showMessageDialog(this.getContentPane(),"Venceu o jogador 2");
			System.exit(0);
		}
		if(a == 1) {
			JOptionPane.showMessageDialog(this.getContentPane(),"Venceu o jogador 1");
			System.exit(0);
		}
		
	}
	
}
