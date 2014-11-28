package pap.ninjaislands.mechanics;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import pap.ninjaislands.entity.PirateZombie;
import pap.ninjaislands.main.Main;

public class GenerateEnemy{

	LinkedList<PirateZombie> pz_list = new LinkedList<PirateZombie>();
	
	private int level = 1;
	private int g_start = 0;
	private int g_max = 8000;
	private int gl_count = g_max / level;
	
	private int side1 = Main.gamemap.x + 10;
	private int side2 = Main.gamemap.x + Main.gamemap.width - 10;
	
	Score score = new Score();
	
	public GenerateEnemy(){
				pz_list.add(new PirateZombie(side1, 1, 0.5));
				pz_list.add(new PirateZombie(side2, 1, 0.6));
	}
	
	public void generateEnemy(){
		int side = new Random().nextInt(2);
		double speedRandom = new Random().nextDouble();
		double minSpeed = 0.0;
		double maxSpeed = 1.0;
		double speed = minSpeed + (maxSpeed - minSpeed) * speedRandom;
		
		if(g_start <= (int)(gl_count/score.getLevel())){
			g_start += 1;
		}else{
			if(side == 0){
				pz_list.add(new PirateZombie(side1, 1, speed));
			}else{
				pz_list.add(new PirateZombie(side2, 1, speed));
			}
			g_start = 0;
		}
		
		removeDeadZombies();
		
	}
	
	public void removeDeadZombies(){
		for(PirateZombie pz : pz_list){
			if(pz.isDeadByWater() || pz.health <= 0){
				pz_list.remove(pz);
			}
		}
	}
	
	public void enemyTick(){
		for(PirateZombie pz : pz_list){
			pz.tick();
		}
	}
	
	public void enemyRender(Graphics g){
		for(PirateZombie pz : pz_list){
			pz.render(g);
		}
	}
	
}
