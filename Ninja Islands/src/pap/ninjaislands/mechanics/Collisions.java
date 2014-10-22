package pap.ninjaislands.mechanics;

import pap.ninjaislands.entity.Ninja;
import pap.ninjaislands.main.Main;
import pap.ninjaislands.world.GameMap;

public class Collisions {
	
	/*
	 * @autor Carlos Almeida
	 */

	public boolean ninjaCollidingWithGround(Ninja ninja){
		
		if((ninja.y+ninja.height) >= GameMap.y+(Main.ZOOM*3) && (ninja.x >= (GameMap.x - ninja.width)) && (ninja.x <= (GameMap.x+GameMap.width))) return true;
			
		return false;
	}
	
}