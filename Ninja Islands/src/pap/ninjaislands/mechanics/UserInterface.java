package pap.ninjaislands.mechanics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pap.ninjaislands.main.Main;

public class UserInterface {

	public int health;
	int lifes; //vidas que o ninja tem
	
	//coordenadas e tamanhos para os retangulos da interface de Jogador
	int x1 = 0;
	int x2 = x1+ 25;
	
	int y1 = Main.ZOOMHEIGHT - 69;
	int y2 = y1 + 25;
	
	int width1 = 70;
	int width2 = width1 - 10;
	int width3 = width1 + 15;
	
	//coordenadas e tamanho para os retangulos da interface de pontos
	
	int sWidth1 = 85;
	int sWidth2 = sWidth1;
	
	int sHeight1 = 25;
	int sHeight2 = 10;
	
	int sX1 = Main.ZOOMWIDTH - sWidth1;
	int sX2 = Main.ZOOMWIDTH - sWidth2;
	
	int sY1 =  Main.ZOOMHEIGHT - 69;
	int sY2 = sY1 + sHeight1;
	
	//Cronometro
	int segundos;
	int minutos;
	int horas;
	int count;
	
	
	int score_per_minute = 20; //pontos atribuidos a cada minuto
	int score_per_hour = 1500; //pontos atribuidos a cada hora
	
	public UserInterface(int health, int lifes){
		this.health = health;
		this.lifes = lifes;
	}
	
	public void timer(){
		count++;
		segundos = count/60;
		if(segundos >= 60){
			count = 0;
			minutos += 1;
			Score.score += score_per_minute;
		}
		if(minutos >= 60){
			count = 0;
			minutos = 0;
			horas += 1;
			Score.score += score_per_hour;
		}
		
	}
	
	public void tick(){
		timer();
	}
	
	public void renderPlayerUI(Graphics g){
		g.setColor(new Color(0, 0, 0));
		g.fillRect(x1, y1, width1, 25);
		
		g.setColor(new Color(5, 5, 5));
		g.fillRect(x2, y1, width2, 25);
		
		g.setColor(new Color(3 ,3 ,3, 100));
		g.fillRect(x1, y2, width3, 10);
		
		//barra de vida
		g.setColor(new Color(180, 230, 30, 170));
		g.fillRect(x1, y2, (int)(health * 0.85), 10);
		
		//borda decorativa
		g.setColor(Color.WHITE);
		g.drawRect(x1-1, y1, width3, 25+10);
		
		g.setFont(new Font("Arial", Font.PLAIN, 9));
		g.drawString("Lives: x"+lifes, 37, y1+15);
	}
	
	public void renderScoreUI(Graphics g){
		//pontos
		g.setColor(new Color(255, 255, 255));
		g.fillRect(sX1, sY1, sWidth1, sHeight1);
		
		//tempo
		g.setColor(new Color(185, 45, 40));
		g.fillRect(sX2, sY2, sWidth2, sHeight2);
		
		//borda decorativa
		g.setColor(new Color(0, 0, 0));
		g.drawRect(sX1, sY1, sWidth1, sHeight1 + sHeight2);
		
		//cronometro
		g.setColor(new Color(255, 255, 255));
		g.drawString(horas+":"+minutos+":"+segundos, sX2 + (sWidth2 / 3) + 5, sY2 + sHeight2 - 1);
		
		//Pontuação
		g.setColor(new Color(3, 3, 3));
		g.drawString("Score:"+Score.getScore(), sX1 + 5, sY1 + (sHeight1 / 2) + Main.ZOOM);
	}
	
	public void render(Graphics g){
		renderPlayerUI(g);
		renderScoreUI(g);
	}
	
}
