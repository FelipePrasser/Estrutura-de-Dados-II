package entidade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.JanelaJogo;
import main.KeyHandler;

public class Jogador extends Entidade{
	JanelaJogo janela;
	KeyHandler tecla;
	
	public Jogador(JanelaJogo janela, KeyHandler tecla) {
		this.janela=janela;
		this.tecla=tecla;
		setValoresPadrao();
		getImagemJogador();
	}
	
	public void setValoresPadrao() {
		//Informações padrão do Jogador:
		posX=100;
		posY=100;
		velocidade=4;//Em pixels;
		direcao="baixo";
	}
	
	public void getImagemJogador() {
		try {
			cima1=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_up_1.png"));
			cima2=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_up_2.png"));
			baixo1=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_down_1.png"));
			baixo2=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_down_2.png"));
			esq1=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_left_1.png"));
			esq2=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_left_2.png"));
			dir1=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_right_1.png"));
			dir2=ImageIO.read(getClass().getResourceAsStream("/jogador/boy_right_2.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (tecla.cimaPressed==true || tecla.baixoPressed==true || tecla.esqPressed==true || tecla.dirPressed==true) {
			//Contador para alternar a imagem de movimento do jogador.
			//A cada 15 quadros, muda a imagem;
			contSprites++;
			if(contSprites>15) {
				if(numSprites==1) {
					numSprites=2;
				}else if(numSprites==2) {
					numSprites=1;
				}
				contSprites=0;
			}
		}
		
		if(tecla.cimaPressed==true) {
			direcao="cima";
			posY=posY-velocidade;
		}
		else if(tecla.baixoPressed==true) {
			direcao="baixo";
			posY=posY+velocidade;
		}
		else if(tecla.esqPressed==true) {
			direcao="esq";
			posX=posX-velocidade;
		}
		else if(tecla.dirPressed==true) {
			direcao="dir";
			posX=posX+velocidade;
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage imagem=null;
		switch (direcao) {
			case "cima":
				if(numSprites==1) {
					imagem=cima1;
				}else if(numSprites==2) {
					imagem=cima2;
				}
				break;
			case "baixo":
				if(numSprites==1) {
					imagem=baixo1;
				}else if(numSprites==2) {
					imagem=baixo2;
				}
				break;
			case "esq":
				if(numSprites==1) {
					imagem=esq1;
				}else if(numSprites==2) {
					imagem=esq2;
				}
				break;
			case "dir":
				if(numSprites==1) {
					imagem=dir1;
				}else if(numSprites==2) {
					imagem=dir2;
				}
				break;
		}
		
		
		g2.drawImage(imagem, posX, posY, janela.tamObj, janela.tamObj, null);
	}
}
