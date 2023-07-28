package entidade;

import java.awt.image.BufferedImage;

public class Entidade {
	public int posX, posY;
	public int velocidade;
	
	public BufferedImage cima1, cima2, baixo1, baixo2, esq1, esq2, dir1, dir2;//Imagens das movimentações das Entidades;
	public String direcao;
	
	public int contSprites=0;
	public int numSprites=1;
}
