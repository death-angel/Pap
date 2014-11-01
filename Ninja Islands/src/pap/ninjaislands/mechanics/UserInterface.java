package pap.ninjaislands.mechanics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pap.ninjaislands.main.Main;

public class UserInterface {

	int health;
	int lifes; //vidas que o ninja tem
	
	//coordenadas e tamanhos para os retangulos
	int x1 = 0;
	int x2 = x1+ 25;
	
	int y1 = Main.ZOOMHEIGHT - 69;
	int y2 = y1 + 25;
	
	int width1 = 70;
	int width2 = width1 - 10;
	int width3 = width1 + 15;
	
	public UserInterface(int health, int lifes){
		this.health = health;
		this.lifes = lifes;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(new Color(0, 0, 0));
		g.fillRect(x1, y1, width1, 25);
		
		g.setColor(new Color(5, 5, 5));
		g.fillRect(x2, y1, width2, 25);
		
		g.setColor(new Color(3 ,3 ,3, 100));
		g.fillRect(x1, y2, width3, 10);
		
		//barra de vida
		g.setColor(new Color(180, 230, 30, 170));
		g.fillRect(x1, y2, (int)(health * 0.85), 10);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 9));
		g.drawString("Lifes: x"+lifes, 37, y1+15);
	}
	
}
