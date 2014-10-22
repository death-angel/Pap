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
			Ninja.isJumping = true;
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
		
		//saltar
		if(key == KeyEvent.VK_SPACE){
			Ninja.isJumping = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
