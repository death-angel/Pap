package pap.ninjaislands.mechanics;

import pap.ninjaislands.entity.Ninja;
import pap.ninjaislands.entity.PirateZombie;
import pap.ninjaislands.main.Main;
import pap.ninjaislands.world.GameMap;

public class Collisions {
	
	/*
	 * @autor Carlos Almeida
	 */

	//colisão para o ninja
	
	public boolean ninjaCollidingWithGround(Ninja ninja){
		
		if((ninja.y+ninja.height) >= GameMap.y+(Main.ZOOM*3) && (ninja.x >= (GameMap.x - ninja.width)) && (ninja.x <= (GameMap.x+GameMap.width))) return true;
			
		return false;
	}
	
	public boolean ninjaIsUnderTheGround(Ninja ninja){
		
		if((ninja.y+ninja.height) > GameMap.y+(Main.ZOOM*3) && (ninja.x >= (GameMap.x - ninja.width)) && (ninja.x <= (GameMap.x+GameMap.width))) return true;
			
		return false;
	}
	
	//colisão para os piratas zombies
	
	public boolean zombieCollidingWithGround(PirateZombie pzombie){
		
		if((pzombie.y+pzombie.height) >= GameMap.y+(Main.ZOOM*3) && (pzombie.x >= (GameMap.x - pzombie.width)) && (pzombie.x <= (GameMap.x+GameMap.width))) return true;
			
		return false;
	}
	
	public boolean zombieIsUnderTheGround(PirateZombie pzombie){
		
		if((pzombie.y+pzombie.height) > GameMap.y+(Main.ZOOM*3) && (pzombie.x >= (GameMap.x - pzombie.width)) && (pzombie.x <= (GameMap.x+GameMap.width))) return true;
			
		return false;
	}
	
	public double distanceToTheSurface(Ninja ninja){
		
		double surfaceY = GameMap.y+(Main.ZOOM*3);
		double ninjaFoot =  ninja.y + ninja.height;
		double distance = ninjaFoot - surfaceY;
		
		return distance;
	}
	
	public double distanceToTheSurface(PirateZombie pzombie){
		
		double surfaceY = GameMap.y+(Main.ZOOM*3);
		double ninjaFoot =  pzombie.y + pzombie.height;
		double distance = ninjaFoot - surfaceY;
		
		return distance;
	}
	
	public boolean isBeingAttackedByZombies(PirateZombie pzombie, Ninja ninja){
		//lado esquerdo
		if(ninja.x <= (pzombie.x + pzombie.width) && (ninja.x+ninja.width) >= (pzombie.x + pzombie.width)) return true;
		//lado direito
		if((ninja.x+ninja.width) >= pzombie.x && ninja.x <= pzombie.x) return true;
				
		return false;
	}
	
	public boolean isBeingAttackedByNinjas(PirateZombie pzombie, Ninja ninja){
		//lado esquerdo
		if(pzombie.x <= (ninja.x + ninja.width) && (pzombie.x+pzombie.width) >= (ninja.x + ninja.width)) return true;
		//lado direito
		if((pzombie.x+pzombie.width) >= ninja.x && pzombie.x <= ninja.x) return true;
		
		return false;
	}
	
	public boolean isBeingAttackedBySuperPower(PirateZombie pzombie){
		if((pzombie.y+pzombie.height) > Ninja.raioY && (pzombie.x >= (Ninja.raioXC - pzombie.width)) && (pzombie.x <= (Ninja.raioXC+Ninja.raioWidth))) return true;
		
		return false;
	}
	
	public boolean isDeadOnTheOcean(Ninja ninja){
		if(ninja.y >= (Main.gamemap.y + (10 * Main.ZOOM) + ninja.height)){
			return true;
		}
		
		return false;
	}
	
}
