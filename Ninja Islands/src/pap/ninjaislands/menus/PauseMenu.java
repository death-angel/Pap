package pap.ninjaislands.menus;

import java.awt.Color;
import java.awt.Graphics;

import pap.ninjaislands.main.Main;
import pap.ninjaislands.mechanics.Debug;

public class PauseMenu {
	
	public String[] menu = new String[2];
	
	public static int count = 0; //contador para selecionar opção do menu
	
	public static boolean selected = false;
	
	public PauseMenu(){
		menu[0] = "Continuar";
		menu[1] = "Sair";
	}
	
	public void tick(){
		//limites do menu
		if(count >= menu.length) count = menu.length-1;
		if(count < 0) count = 0;
		
		//seleção escolhida
			if(selected){
				if(count == 0){
					Main.isPaused = false;
					selected = false;
				}else if(count == 1){
					//desligar o jogo
					Debug.Print("Aplicação fechada");
					Main.janela.dispose();
					System.exit(0);
				}
			}
	}
	
	public void render(Graphics g){
		if(Main.isPaused){
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(0, 0, Main.ZOOMWIDTH, Main.ZOOMHEIGHT);
			
			for(int i = 0; i < menu.length; i++){
				if(count == i){
					g.setColor(Color.GREEN);
				}else{
					g.setColor(Color.WHITE);
				}
				g.drawString(menu[i], Main.ZOOMWIDTH/2 - menu[0].length()*menu.length, Main.ZOOMHEIGHT/2 + i*20);
			}
		}
	}
	
}
