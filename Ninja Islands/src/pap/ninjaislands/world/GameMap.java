package pap.ninjaislands.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanics.ImageLoad;

public class GameMap{
	
	/*
	 * @autor Carlos Almeida
	 */
	
	public static int x;
	public static int y;
	public static int width;
	public static int height;
	
	Rectangle mapa = new Rectangle();

	public GameMap(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		mapa.setBounds(x, y, width, height);
	}
	
	public void render(Graphics g){
		g.drawImage(ImageLoad.ilhas, x - (int)Main.OFFSETX, y - (int)Main.OFFSETY, width, height, null);
	}
	
}
