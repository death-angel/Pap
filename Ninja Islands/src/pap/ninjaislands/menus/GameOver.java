package pap.ninjaislands.menus;

import java.awt.Color;
import java.awt.Graphics;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanics.Score;

public class GameOver {
	
	public boolean exited = false;
	
	public void tick(){
		if(exited){
			Main.janela.dispose();
			System.exit(0);
		}
	}

	public void render(Graphics g){
		if(Main.died){
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(0, 0, Main.ZOOMWIDTH, Main.ZOOMHEIGHT);
			
			g.setColor(Color.WHITE);
			g.drawString("You died! Score:"+Score.score, Main.ZOOMWIDTH/2 - (16*12)/5, Main.ZOOMHEIGHT/2 - (7*2));
			g.drawString("Press ENTER to exit the game", Main.ZOOMWIDTH/2 - (26*12)/5, Main.ZOOMHEIGHT/2 - (7));
		}
	}
	
}
