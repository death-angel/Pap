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
	
	public double currentFallSpeed = 0.1;
	public double maxFallSpeed = 2.5;
	public static double charWalkSpeed = 1.0;
	public static int width; 
	public static int height;
	//calculo para centrar personagem no meio do ecra
	public static double x = Main.ZOOMWIDTH/2 - width/2;
	public static double y = Main.ZOOMHEIGHT/2 - height/2 - 30;
	
	public static double dir; //dire��o do personagem (esquerda < 0, direita > 0)
	
	//Variaveis para sistema de salto
	public static boolean isJumping = false;
	public double jumpSpeed = 5;
	public double currentJumpSpeed = jumpSpeed;
	
	//anima��o de andar
	public int wanimation;
	public int wanimation_frame;
	public int wanimation_time = 17;
	
	//anima��o parado
	public int sanimation;
	public int sanimation_frame;
	public int sanimation_time = 45;
	
	Collisions collisions;
	GameMap gamemap;
	
	public static boolean isFalling = true;
	public static boolean isWalking = false;
	
	public Ninja(int width, int height){
		this.width = width;
		this.height = height;
		collisions = new Collisions();
	}
	
	public void tick(){
		//gravidade
		if(isFalling){
			y += currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed){
				currentFallSpeed += 0.1;
			}
			
		}
		//colis�o
		if(collisions.ninjaCollidingWithGround(this)){
			isFalling = false;
			
			if(collisions.ninjaIsUnderTheGround(this)){
				y -= collisions.distanceToTheSurface(this); //resolver o problema em que o ninja ficava enterrado no terreno da ilha
			}
			
		}else{
			isFalling = true;
		}
		//movimento de andar
		if(isWalking){
			x += dir;
			Main.OFFSETX += dir; 
			
			sanimation = 0;
			
			//anima��o de andar
			if(wanimation_frame >= wanimation_time){
				if(wanimation > 1){
					wanimation = 1;
				}else{
					wanimation += 1;
				}
				wanimation_frame = 0;
			}else{
				wanimation_frame +=1;
			}
			
		}else{
			wanimation = 0;
			if(!isJumping){
				//anima��o de parado
				if(sanimation_frame >= sanimation_time){
					if(sanimation > 1){
						sanimation = 1;
					}else{
						sanimation += 1;
					}
					sanimation_frame = 0;
				}else{
					sanimation_frame +=1;
				}
			}
		}
		
		//salto
		if(isJumping){
			y -= currentJumpSpeed;
			currentJumpSpeed -= 0.1;
			
			if(currentJumpSpeed <= 0){
				currentJumpSpeed = jumpSpeed;
				isJumping = false;
				isFalling = true;
			}
		}
		
	}
	
	public void render(Graphics g){
		if(isWalking){
			if(dir > 0){
				g.drawImage(ImageLoad.ninja, (int)(x+width) - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(x+width)-width - (int)Main.OFFSETX, (int)(y+height) - (int)Main.OFFSETY,/**/0*width+(width*wanimation), 0 * height, (0*width) + width + (wanimation*width), (0*height) + height,null);//inverte a imagem
			}else{
				g.drawImage(ImageLoad.ninja, (int)x - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(x+width) - (int)Main.OFFSETX, (int)(y+height) - (int)Main.OFFSETY,/**/0*width+(width*wanimation), 0 * height, (0*width) + width + (wanimation*width), (0*height) + height, null);//imagem normal
			}
		}else{
			if(dir > 0){
				g.drawImage(ImageLoad.ninja, (int)(x+width) - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(x+width)-width - (int)Main.OFFSETX, (int)(y+height) - (int)Main.OFFSETY,/**/0*width+(width*sanimation), 1 * height, (0*width) + width + (sanimation*width), (1*height) + height,null);//inverte a imagem
			}else{
				g.drawImage(ImageLoad.ninja, (int)x - (int)Main.OFFSETX, (int)y - (int)Main.OFFSETY, (int)(x+width) - (int)Main.OFFSETX, (int)(y+height) - (int)Main.OFFSETY,/**/0*width+(width*sanimation), 1 * height, (0*width) + width + (sanimation*width), (1*height) + height, null);//imagem normal
			}
		}
	}
	
}
