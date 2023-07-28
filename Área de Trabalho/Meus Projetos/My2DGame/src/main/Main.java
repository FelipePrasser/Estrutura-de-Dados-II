package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame janela = new JFrame();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Para fechar a janela quando clicar no 'X';
		janela.setResizable(false);// Para a janela não ser redimensionável;
		janela.setTitle("2d Adventure");// Título da janela;
		
		JanelaJogo janelaJogo=new JanelaJogo();
		janela.add(janelaJogo);
		janela.pack();
		
		janela.setLocationRelativeTo(null);//Para a janela ficar no centro da tela;
		janela.setVisible(true);//Para a janela seja visível;
		
		janelaJogo.startGameThread();
	}
}
