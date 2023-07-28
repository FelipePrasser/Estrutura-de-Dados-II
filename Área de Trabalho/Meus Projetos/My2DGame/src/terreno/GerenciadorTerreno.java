package terreno;

import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import main.JanelaJogo;

public class GerenciadorTerreno{
	JanelaJogo janela;
	Terreno [] terreno;
	
	public GerenciadorTerreno(JanelaJogo janela) {
		this.janela=janela;
		terreno=new Terreno[10];
		getImagemTerreno();
	}
	
	public void getImagemTerreno() {
		try {
			terreno[0]=new Terreno();
			terreno[0].imagem=ImageIO.read(getClass().getResourceAsStream("/terrenos/grass.png"));
			terreno[1]=new Terreno();
			terreno[1].imagem=ImageIO.read(getClass().getResourceAsStream("/terrenos/wall.png"));
			terreno[2]=new Terreno();
			terreno[2].imagem=ImageIO.read(getClass().getResourceAsStream("/terrenos/water.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(terreno[1].imagem, 0, 0, janela.tamObj, janela.tamObj, null);
	}
}
