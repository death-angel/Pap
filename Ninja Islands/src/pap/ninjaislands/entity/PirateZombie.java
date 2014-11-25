package pap.ninjaislands.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanics.Collisions;
import pap.ninjaislands.mechanics.ImageLoad;
import pap.ninjaislands.mechanics.Score;

public class PirateZombie {
	
	public int model;
	public int width = 9;
	public int height = 22;
	
	public double x;
	public double y =  Main.ZOOMHEIGHT/2 - height/2 - 30;
	public double dir;
	public double movement_speed;
	public double currentFallSpeed = 0.1;
	public double maxFallSpeed = 2.5;
	
	//animação de andar
		public int wanimation = 1;
		public int wanimation_frame;
		public int wanimation_time = 4;
	
	public boolean isFalling = true;
	public boolean isWalking = true;
	
	Collisions collisions;
	
	public PirateZombie(double x, int model, double movement_speed){
		this.x = x;
		this.model = model;
		this.movement_speed = movement_speed;
		collisions = new Collisions();
	}
	
	public void tick(){
		if(isWalking){
			x += dir;
			walkingAnimation();
		}
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
		
		AI();
		
	}
	
	public void AI(){
		//Basica Inteligencia artifial
				if(x > Ninja.x){
					dir = -movement_speed;
				}else{
					dir = movement_speed;
				}
	}
	
	public boolean isDeadByWater(){
		if(y >= (Main.gamemap.y + (10 * Main.ZOOM) + height)){
			Score.score += 20;
			return true;
		}
		
		return false;
	}
	
	public void walkingAnimation(){
		//animação de andar
				if(wanimation_frame >= wanimation_time){
					if(wanimation > 2){
						wanimation = 0;
					}else{
						wanimation += 1;
					}
					wanimation_frame = 0;
				}else{
					wanimation_frame +=1;
				}
	}
	
	public BufferedImage getPirateModel(int model){
		if(model == 1) return ImageLoad.pirate_zombie_model1;
		
		return null;
	}
	
	public void render(Graphics g){
		if(isWalking){
			if(dir > 0){
				g.drawImage(getPirateModel(model), (int)(x+width) - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(x+width)-width - (int)Main.OFFSETX, (int)(y+height) - (int)Main.OFFSETY,/*animação*/(width*wanimation), 0, width + (wanimation*width), height,null);//inverte a imagem
			}else{
				g.drawImage(getPirateModel(model), (int)x - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(x+width) - (int)Main.OFFSETX, (int)(y+height) - (int)Main.OFFSETY,/**/(width*wanimation), 0, width + (wanimation*width), height, null);//imagem normal
			}
		}
	}
	
}
