package pap.ninjaislands.mechanics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pap.ninjaislands.main.Main;

public class UserInterface {

	int health;
	int lifes; //vidas que o ninja tem
	
	public UserInterface(int health, int lifes){
		this.health = health;
		this.lifes = lifes;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, Main.ZOOMHEIGHT - 50, 70, 25);
		
		g.setColor(new Color(5, 5, 5));
		g.fillRect(25, Main.ZOOMHEIGHT - 50, 60, 25);
		
		g.setColor(new Color(3 ,3 ,3, 75));
		g.fillRect(0, Main.ZOOMHEIGHT - 25, 85, 10);
		
		//barra de vida
		g.setColor(new Color(180, 230, 30, 170));
		g.fillRect(0, Main.ZOOMHEIGHT - 25, (int)(health * 0.85), 10);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 9));
		g.drawString("Lifes: x"+lifes, 37, Main.ZOOMHEIGHT-35);
	}
	
}
