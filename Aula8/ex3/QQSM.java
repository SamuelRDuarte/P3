package Aula8.ex3;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.*;


import javax.imageio.ImageIO;
import javax.swing.*;


public class QQSM extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Questoes questoes;
    private Questao questao;
    private JLabel amount, picture;
    private JTextArea questionText;
    private JButton publico, call, fifty;
    private JRadioButton o1, o2, o3, o4;
    private ButtonGroup options;

	public static void main(String[] args) throws IOException{
		new QQSM("C:\\Users\\samue\\OneDrive - Universidade de Aveiro\\Universidade\\2Ano\\P3\\aula8_material\\aula8_material\\QQSM\\questions.txt");

	}

	public QQSM(String fileName) throws IOException{
		super("Quem Quer Ser Milionario");
		
		questoes = new Questoes(fileName);
		questao = questoes.getQuestao();
		
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initiateGUI(this.getContentPane());
		pack();
		setVisible(true);
	}
	
	private void initiateGUI(Container contentPane) throws IOException{
		amount = new JLabel("Pote: "+String.valueOf(questao.getPremio())+"€",SwingConstants.CENTER);
		contentPane.add(amount,BorderLayout.PAGE_START);
		
		picture = new JLabel(new ImageIcon(ImageIO.read(new File(questao.getImgPath())).getScaledInstance(250, 250, 0)));
		picture.setPreferredSize(new Dimension(300,300));
		contentPane.add(picture,BorderLayout.LINE_START);
		
		questionText = new JTextArea(questao.getPergunta());
		questionText.setPreferredSize(new Dimension(100,20));
		questionText.setEditable(false);
		questionText.setLineWrap(true);
		questionText.setWrapStyleWord(true);
		questionText.setFont(questionText.getFont().deriveFont(20f));
		contentPane.add(questionText,BorderLayout.CENTER);
		
		o1 = new JRadioButton("<html>" + questao.getOpçao(0) + "</html>");
	    o2 = new JRadioButton("<html>" + questao.getOpçao(1) + "</html>");
	    o3 = new JRadioButton("<html>" + questao.getOpçao(2) + "</html>");
	    o4 = new JRadioButton("<html>" + questao.getOpçao(3) + "</html>");
		
	    options = new ButtonGroup();
	    options.add(o1);
	    options.add(o2);
	    options.add(o3);
	    options.add(o4);
	    
	    JPanel radioPanel = new JPanel(new GridLayout(2,2));
	    radioPanel.setPreferredSize(new Dimension(50,50));
	    radioPanel.add(o1);
	    radioPanel.add(o2);
	    radioPanel.add(o3);
	    radioPanel.add(o4);
	    
	    publico = new JButton("Publico");
	    call = new JButton("Chamada");
	    fifty = new JButton("50-50");
	    JButton giveup = new JButton("Desisto");
	    JButton confirm = new JButton("Confirmo");
	    
	    JPanel helpPanel = new JPanel();
	    helpPanel.add(publico);
	    helpPanel.add(call);
	    helpPanel.add(fifty);
	    
	    JPanel actionPanel = new JPanel();
	    actionPanel.add(giveup);
	    actionPanel.add(confirm);
	    
	    JPanel buttonPanel = new JPanel(new BorderLayout());
	    buttonPanel.add(helpPanel,BorderLayout.WEST);
	    buttonPanel.add(actionPanel,BorderLayout.EAST);
	    buttonPanel.add(radioPanel,BorderLayout.NORTH);
	    buttonPanel.add(actionPanel,BorderLayout.PAGE_END);
	    
	    confirm.addActionListener(e -> 
	    	{
	    		for(JRadioButton but : new JRadioButton[] {o1,o2,o3,o4}) {
	    			if(but.isSelected()) {
	    				if(isSolution(but)) {
	    					try {
								nextQuestionWin();
							} catch (IOException e1) {
								e1.printStackTrace();
								endGame();
							}
	    				}else
	    					lose();
	    			}
	    		}
	    	});
	    
	    giveup.addActionListener(e -> endGame());    
	}
	
	private void displayNextQuestion() throws IOException {
		questao = questoes.getQuestao();
		amount.setText(String.valueOf(questao.getPremio())+"€");
		picture.setIcon(new ImageIcon(ImageIO.read(new File(questao.getImgPath()))));
		questionText.setText(questao.getPergunta());
		
		options.clearSelection();
		
		o1.setText("<html>" + questao.getOpçao(0) + "</html>");
        o1.setEnabled(true);
        
        o2.setText("<html>" + questao.getOpçao(1) + "</html>");
        o2.setEnabled(true);
        
        o3.setText("<html>" + questao.getOpçao(2) + "</html>");
        o3.setEnabled(true);
        
        o4.setText("<html>" + questao.getOpçao(3) + "</html>");
        o4.setEnabled(true);
	}
	
	private void nextQuestionWin() throws IOException{
		if(questoes.naoHaQuestao())
			win();
		else {
			JOptionPane.showMessageDialog(this.getContentPane(), "Correto!");
			displayNextQuestion();
		}
	}
	
	private String getButtonText(JRadioButton b) {
		String butText = b.getText();
		return butText.substring(6, butText.length()-7);
	}
	
	private boolean isSolution(JRadioButton but) {
		return questao.getResposta().equals(getButtonText(but));
	}
	
	private void win() {
		JOptionPane.showMessageDialog(this.getContentPane(), "Ganhou o premio maximo de "+questao.getPremio()+"€.");
		endGame();
	}
	
	private void lose() {
		JOptionPane.showMessageDialog(this.getContentPane(), "Perdeu. Premio de consolaçao "+questoes.ultimaQuestaoPremio()+"€.");
		endGame();
	}
	
	private void endGame() 
    {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
