package pap.ninjaislands.entity;

import java.awt.Graphics;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanical.Collisions;
import pap.ninjaislands.mechanical.ImageLoad;
import pap.ninjaislands.world.GameMap;

public class Ninja{
	
	/*
	 * @autor Carlos Almeida
	 */
	
	public double charSpeed = 1.2;
	public int width; 
	public int height;
	//calculo para centrar personagem no meio do ecra
	public double x = Main.ZOOMWIDTH/2 - width/2;
	public double y = Main.ZOOMHEIGHT/2 - height/2 - 30;
	
	public int dir = 1; //direção do personagem (esquerda = 0, direita = 1)
	
	Collisions collisions;
	GameMap gamemap;
	
	public boolean isFalling = true;
	
	public Ninja(int width, int height){
		this.width = width;
		this.height = height;
		collisions = new Collisions();
	}
	
	public void tick(){
		if(isFalling) y += 1.2;
		if(collisions.ninjaCollidingWithGround(this)){
			isFalling = false;
		}
	}
	
	public void render(Graphics g){
		if(dir > 0){
			g.drawImage(ImageLoad.ninja, (int)x+width, (int)y, -width, height, null);//inverte a imagem
		}else{
			g.drawImage(ImageLoad.ninja, (int)x, (int)y, width, height, null);//imagem normal
		}
	}
	
}
