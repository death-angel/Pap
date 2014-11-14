package pap.ninjaislands.mechanics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pap.ninjaislands.main.Main;

public class Inventory {

	public int number_of_weapons = 3;
	
	public String[] weapons_name = new String[number_of_weapons];
	public int[] weapons_damage = new int[number_of_weapons];
	public int[] weapons_ammunition = new int[number_of_weapons];
	public BufferedImage[] weapon_img = new BufferedImage[number_of_weapons];
	
	public int selected_weapon = 2;	
	
	public Inventory(){
		//nomes das armas
		weapons_name[0] = "Hands";
		weapons_name[1] = "Sword";
		weapons_name[2] = "Bow";
		//quantidade de dano
		weapons_damage[0] = 0;
		weapons_damage[1] = 15;
		weapons_damage[2] = 10;
		//munição de cada arma
		weapons_ammunition[0] = 2; //2 mãos
		weapons_ammunition[1] = 1; //1 espada
		weapons_ammunition[2] = 5; //5 flexas
		//imagens das armas
		weapon_img[0] = ImageLoad.hand_gui;
		weapon_img[1] = ImageLoad.sword_gui;
		weapon_img[2] = ImageLoad.bow_gui;
		
	}
	
	public void tick(){
		//definir limites
		if(selected_weapon > number_of_weapons - 1) selected_weapon = number_of_weapons;
		if(selected_weapon < 0) selected_weapon = 0;
	}

	public BufferedImage selectedWeapon(int weapon){
		return weapon_img[weapon];
	}
	
	public void render(Graphics g){
		g.drawImage(selectedWeapon(selected_weapon), Main.ui.width1/4, Main.ui.y1+Main.ZOOM, null);
	}
	
	
}
