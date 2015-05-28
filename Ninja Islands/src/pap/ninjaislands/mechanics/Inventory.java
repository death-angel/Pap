package pap.ninjaislands.mechanics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pap.ninjaislands.main.Main;

public class Inventory {

	public int number_of_weapons = 2;
	
	public String[] weapons_name = new String[number_of_weapons];
	public int[] weapons_damage = new int[number_of_weapons];
	public int[] weapons_ammunition = new int[number_of_weapons];
	public BufferedImage[] weapon_img = new BufferedImage[number_of_weapons];
	
	public int selected_weapon = 0;	
	
	public Inventory(){
		//nomes das armas
		weapons_name[0] = "Hands";
		weapons_name[1] = "Sword";
		//quantidade de dano
		weapons_damage[0] = 0;
		weapons_damage[1] = 15;
		//munição de cada arma
		weapons_ammunition[0] = 2; //2 mãos
		weapons_ammunition[1] = 1; //1 espada
		//imagens das armas
		weapon_img[0] = ImageLoad.hand_gui;
		weapon_img[1] = ImageLoad.sword_gui;
		
	}
	
	public void tick(){
		//definir limites
		if(selected_weapon > (number_of_weapons - 1)) selected_weapon = number_of_weapons - 1;
		if(selected_weapon < 0) selected_weapon = 0;
	}

	public BufferedImage selectedWeapon(int weapon){
		return weapon_img[weapon];
	}
	
	public void render(Graphics g){
		g.drawImage(selectedWeapon(selected_weapon),
					((Main.ui.x2 - Main.ui.x1) / 2) - ((selectedWeapon(selected_weapon).getWidth())), 
					Main.ui.y1+Main.ZOOM, 
					selectedWeapon(selected_weapon).getWidth() * Main.ZOOM/2, 
					selectedWeapon(selected_weapon).getHeight() * Main.ZOOM/2,
		null);
	}
	
	
}
