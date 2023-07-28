package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean cimaPressed, baixoPressed, esqPressed, dirPressed;
	@Override
	public void keyTyped(KeyEvent e) {	
	}
	
	//Indica que a tecla foi pressionada;
	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();//retorna o número do código da tecla pressionada;
		
		if (code==KeyEvent.VK_W) {
			cimaPressed=true;
		}
		if (code==KeyEvent.VK_S) {
			baixoPressed=true;
		}
		if (code==KeyEvent.VK_A) {
			esqPressed=true;
		}
		if (code==KeyEvent.VK_D) {
			dirPressed=true;
		}
		
	}
	
	//Indica que a tecla foi solta;
	@Override
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();
		
		if (code==KeyEvent.VK_W) {
			cimaPressed=false;
		}
		if (code==KeyEvent.VK_S) {
			baixoPressed=false;
		}
		if (code==KeyEvent.VK_A) {
			esqPressed=false;
		}
		if (code==KeyEvent.VK_D) {
			dirPressed=false;
		}		
	}
	
}
