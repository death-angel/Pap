package pap.ninjaislands.entity;

import java.awt.Graphics;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.resource.ImageLoad;

public class Ninja{
	
	/*
	 * @autor Carlos Almeida
	 */
	
	public double charSpeed = 1.2;
	public double width; 
	public double height;
	//calculo para centrar personagem no meio do ecra
	public double x = (Main.WIDTH/2/Main.ZOOM)-(width/2);
	public double y = (Main.HEIGHT/Main.ZOOM)-(Main.HEIGHT/2 / Main.ZOOM)-(height/2);
	
	public int dir = 1; //direção do personagem (esquerda = 0, direita = 1)
	
	public Ninja(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
			g.drawImage(ImageLoad.ninja, (int)x, (int)y, (int)width, (int)height, null);
	}
	
}
