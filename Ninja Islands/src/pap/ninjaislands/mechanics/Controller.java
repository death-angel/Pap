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
		
		if(!Main.isPaused){
			if(key == KeyEvent.VK_ENTER){
					Main.isPaused = true;			
			}

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
			
			//mudar de arma
			if(key == KeyEvent.VK_Q && Main.inventory.selected_weapon != 0) Main.inventory.selected_weapon -= 1;
			if(key == KeyEvent.VK_E && Main.inventory.selected_weapon != Main.inventory.number_of_weapons-1) Main.inventory.selected_weapon += 1;
			
			//atacar
			
			if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_S) || (key == KeyEvent.VK_D)) {
				if(Main.inventory.selected_weapon == 1)	Main.ninja.isAttacking = true;
			}
			
			if(key == KeyEvent.VK_ESCAPE){
				if(Main.died) Main.go.exited = true;
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
		
		if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_S) || (key == KeyEvent.VK_D)) {
			if(Main.inventory.selected_weapon == 1)	Main.ninja.isAttacking = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
