package pap.ninjaislands.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanics.Collisions;
import pap.ninjaislands.mechanics.ImageLoad;

public class PirateZombie {
	
	public int model;
	public int width = ImageLoad.pirate_zombie_model1.getWidth();
	public int height = ImageLoad.pirate_zombie_model1.getHeight();
	
	public double x;
	public double y =  Main.ZOOMHEIGHT/2 - height/2 - 30;
	public double dir;
	public double movement_speed = 0.5;
	public double currentFallSpeed = 0.1;
	public double maxFallSpeed = 2.5;
	
	public boolean isFalling = true;
	
	Collisions collisions;
	
	public PirateZombie(double x, int model){
		this.x = x;
		this.model = model;
		collisions = new Collisions();
	}
	
	public void tick(){
		
		x += dir;
		
		if(isFalling){
			y += currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed){
				currentFallSpeed += 0.1;
			}
			
		}
		
		//colisao
		if(collisions.zombieCollidingWithGround(this)){
			isFalling = false;
			
			if(collisions.zombieIsUnderTheGround(this)){
				y -= collisions.distanceToTheSurface(this); //resolver o problema em que o ninja ficava enterrado no terreno da ilha
			}
			
		}else{
			isFalling = true;
		}
		
		//Basica Inteligencia artifial
		if(x > Ninja.x){
			dir = -movement_speed;
		}else{
			dir = movement_speed;
		}
		
	}
	
	public BufferedImage getPirateModel(int model){
		if(model == 1) return ImageLoad.pirate_zombie_model1;
		
		return null;
	}
	
	public void render(Graphics g){
		if(dir > 0){
			g.drawImage(getPirateModel(model), (int)(x+width) - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(-width), (int)height,null);
		}else{
			g.drawImage(getPirateModel(model), (int)x - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(width), (int)(height),null);
		}
	}
	
}
