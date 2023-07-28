package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entidade.Jogador;
import terreno.GerenciadorTerreno;

public class JanelaJogo extends JPanel implements Runnable{
	// Configurações de tela:
	private final int tamanhoOriginalObj = 16;// Todos os objetos terão um tamanho padrão de 16x16 px;
	private final int escala = 3;// Para redimensionar os objetos para ficarem maiores na janela;
	public final int tamObj = tamanhoOriginalObj * escala;// O tamanho que cada objeto aparecerá na tela será de 48x48 px devido à escala;
	
	private final int numMaxColunas=16;//Número máximo de colunas, tendo como medida o tamObj;
	private final int numMaxLinhas=12;//Número máximo de linhas, tendo como medida o tamObj;
	private final int larguraTela=tamObj*numMaxColunas;//768 px;
	private final int alturaTela=tamObj*numMaxLinhas;//576 px;
	
	KeyHandler tecla=new KeyHandler();
	Thread gameThread;
	Jogador jogador=new Jogador(this, tecla);
	GerenciadorTerreno terreno=new GerenciadorTerreno(this);
	

	private int fps=60;
	
	public JanelaJogo() {
		this.setPreferredSize(new Dimension(larguraTela, alturaTela));//Setando a dimensão da janela;
		this.setBackground(Color.black);//Setando a cor de fundo;
		this.setDoubleBuffered(true);//Melhorar o desempenho da renderização, pois armazena sempre a próxima janela armazenada de modo que evita possíveis BUGS;
		this.addKeyListener(tecla);//Reconhecer a entrada da tecla;
		this.setFocusable(true);//Permite que o componente receba o foco do evento do teclado;
	}
	
	public void startGameThread() {
		gameThread=new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double intervaloDesenho=1000000000/fps;
		double proxTempoDesenho=System.nanoTime()+intervaloDesenho;
		while(gameThread!=null)	{
			//Enquanto o processo do jogo existir, o loop persistirá;
			//O loop tem 2 objetivos:
				//UPDATE: fazer update das informações da posição do personagem;
			update();
				//DESENHAR: desenhar na janela com o update das informações;
			repaint();//Assim que se chama o método paintComponent;
			try {
				double tempoRestante=proxTempoDesenho-System.nanoTime();
				tempoRestante=tempoRestante/1000000;
				if(tempoRestante<0) {
					tempoRestante=0;
				}
				Thread.sleep((long)tempoRestante);
				proxTempoDesenho=proxTempoDesenho+intervaloDesenho;
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		jogador.update();
	}
	
	//Método padrão para desenha coisas no JPanel
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;//Converte o Graphics g para a classe Graphics2D;
		jogador.draw(g2);
		terreno.draw(g2);
		g2.dispose();//O programa funciona sem essa linha, mas ela economiza memória;
		
	}
}
