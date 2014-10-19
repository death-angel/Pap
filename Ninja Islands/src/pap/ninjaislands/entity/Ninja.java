package pap.ninjaislands.entity;

import java.awt.Graphics;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanics.Collisions;
import pap.ninjaislands.mechanics.ImageLoad;
import pap.ninjaislands.world.GameMap;

public class Ninja{
	
	/*
	 * @autor Carlos Almeida
	 */
	
	public double charFallingSpeed = 1.5;
	public static double charWalkSpeed = 1.2;
	public static int width; 
	public static int height;
	//calculo para centrar personagem no meio do ecra
	public static double x = Main.ZOOMWIDTH/2 - width/2;
	public static double y = Main.ZOOMHEIGHT/2 - height/2 - 30;
	
	public static double dir; //direção do personagem (esquerda < 0, direita > 0)
	
	Collisions collisions;
	GameMap gamemap;
	
	public boolean isFalling = true;
	public static boolean isWalking = false;
	
	public Ninja(int width, int height){
		this.width = width;
		this.height = height;
		collisions = new Collisions();
	}
	
	public void tick(){
		//gravidade
		if(isFalling) y += charFallingSpeed;
		if(collisions.ninjaCollidingWithGround(this)){
			isFalling = false;
		}else{
			isFalling = true;
		}
		//movimento de andar
		if(isWalking){
			x += dir;
			Main.OFFSETX += dir; 
		}
		
	}
	
	public void render(Graphics g){
		if(dir > 0){
			g.drawImage(ImageLoad.ninja, (int)(x+width) - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, -width, height, null);//inverte a imagem
		}else{
			g.drawImage(ImageLoad.ninja, (int)x - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, width, height, null);//imagem normal
		}
	}
	
}
