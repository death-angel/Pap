package pap.ninjaislands.mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pap.ninjaislands.entity.Ninja;
import pap.ninjaislands.main.Main;

public class Controller implements KeyListener{

	/*
	 * @autor Carlos Almeida
	 */
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); //obtem o codigo da tecla pressionada 
		
		//andar
		if(key == KeyEvent.VK_RIGHT){
			Ninja.isWalking = true;
			Ninja.dir = Ninja.charWalkSpeed;
		}
		
		if(key == KeyEvent.VK_LEFT){
			Ninja.isWalking = true;
			Ninja.dir = -Ninja.charWalkSpeed;
		}
		
		//saltar
		if(key == KeyEvent.VK_SPACE){
			if(!Ninja.isFalling)Ninja.isJumping = true;
		}
		
		if(!Main.isPaused){
			if(key == KeyEvent.VK_ENTER){
					Main.isPaused = true;			
			}
			
		}else if(Main.isPaused){
			if(key == KeyEvent.VK_ENTER){
					Main.pausemenu.selected = true;
			}	
			
			if(key == KeyEvent.VK_UP){
				Main.pausemenu.count -= 1;
			}
			
			if(key == KeyEvent.VK_DOWN){
				Main.pausemenu.count += 1;
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode(); //obtem o codigo da tecla pressionada e largada
		
		if(key == KeyEvent.VK_RIGHT){
			Ninja.isWalking = false;
		}
		
		if(key == KeyEvent.VK_LEFT){
			Ninja.isWalking = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
