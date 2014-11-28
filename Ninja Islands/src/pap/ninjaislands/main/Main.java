package pap.ninjaislands.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pap.ninjaislands.entity.Ninja;
import pap.ninjaislands.entity.PirateZombie;
import pap.ninjaislands.mechanics.Controller;
import pap.ninjaislands.mechanics.GenerateEnemy;
import pap.ninjaislands.mechanics.ImageLoad;
import pap.ninjaislands.mechanics.Inventory;
import pap.ninjaislands.mechanics.UserInterface;
import pap.ninjaislands.menus.GameOver;
import pap.ninjaislands.menus.PauseMenu;
import pap.ninjaislands.world.GameMap;

public class Main implements Runnable{
	
	/*
	 * @autor Carlos Almeida
	 */

	public static JFrame janela;
	
	private String nome = "Ninja vs Zombie Pirates - Alpha - 0.5.0";
	
	//comprimento do ecra
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	//largura do ecra
	public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static int ZOOM = 4;
	public static int ZOOMWIDTH = WIDTH/ZOOM;
	public static int ZOOMHEIGHT = HEIGHT/ZOOM;
	
	public static double OFFSETX = 0;
	public static double OFFSETY = 0;
	
	private int MAPX = 0;
	private int MAPY = ZOOMHEIGHT/2+ZOOM;
	private int MAPWIDTH = 188 * ZOOM;
	private int MAPHEIGHT = 27 * ZOOM;
	
	private int NINJAWIDTH = 13;
	private int NINJAHEIGHT = 19;
	
	public int health = 100;
	public int lives = 1;
	
	public boolean isRunning = false;//estado do jogo: true = jogar false = pausa
	public static boolean isPaused = false;
	public static boolean died = false;
	
	//mar
	public int marX = 0;
	
	Image screen; //vai servir para não se notar as transaçoes das frames
	public static GameMap gamemap;
	public static Ninja ninja;
	public static PauseMenu pausemenu;
	public static UserInterface ui;
	public static Inventory inventory;
	public static GenerateEnemy ge;
	public static GameOver go;
	
	public Main(){
		janela = new JFrame();//inicializar
		janela.setTitle(nome); //definir nome da janela 
		janela.setSize(WIDTH, HEIGHT); //definir tamanho da janela
		janela.setResizable(false); //false = nao permitir mudar resolução da janela
		janela.setLocationRelativeTo(null); //centrar janela no ecra
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fechar corretamente a janela
		janela.setUndecorated(true); //retirar bordas da janela fazendo com que esta fique fullscreen
		janela.setVisible(true);
		
		janela.addKeyListener(new Controller()); //controlos
		
		new ImageLoad();
		gamemap = new GameMap(MAPX, MAPY, MAPWIDTH, MAPHEIGHT);
		ninja = new Ninja(NINJAWIDTH, NINJAHEIGHT);
		pausemenu = new PauseMenu();
		ui = new UserInterface(health, lives);
		inventory = new Inventory();
		ge = new GenerateEnemy();
		go = new GameOver();
		
		isRunning = true;
		new Thread(this).start();
	}
	
	public void tick(){
		//logicas
		if(!died){
			if(!isPaused){
				ninja.tick();
				ui.tick();
				inventory.tick();
				ge.enemyTick();
				ge.generateEnemy();
			}else{
				pausemenu.tick();
			}
		}else{
			go.tick();
		}
	}
	
	public void render(){
		//graficos
		Graphics g = screen.getGraphics(); //inicialização
			//Fundo/ceu
			g.setColor(new Color(153, 217, 234)); //definir cor em RGB
			g.fillRect(0, 0, ZOOMWIDTH, ZOOMHEIGHT); //desenhar retangulo preenchido
			
			//renderizar mapa
			gamemap.render(g);
			//renderizar ninja
			ninja.render(g);
			
			ge.enemyRender(g);
			
			//mar
			g.setColor(new Color(0, 162, 232, 225));
			g.fillRect(marX, gamemap.y + (10 * ZOOM), ZOOMWIDTH, ZOOMHEIGHT - gamemap.y);
			
			//user interface
			ui.render(g);
			
			inventory.render(g);
			
			if(isPaused && !died){
				//menu de pausa
				pausemenu.render(g);
			}
			
			if(died){
				go.render(g);
			}
		
		g = janela.getGraphics(); //obter graficos
		
		g.drawImage(screen, 0, 0, WIDTH, HEIGHT, 0, 0, WIDTH/ZOOM, HEIGHT/ZOOM, null);//mostrar imagem
		
		g.dispose(); //libertar memória
		
	}
	
	public void run(){
		//calculo para jogar o jogo a 60 FPS
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D; //nano segundos em um movimento (tick)
		
		int ticks = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		screen = janela.createVolatileImage(WIDTH/ZOOM, HEIGHT/ZOOM);
		while(isRunning){
			//Ciclo do jogo
			long now = System.nanoTime();
			delta += (now - lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			while(delta >= 1){
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			
			if(shouldRender){
				render();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000){
				lastTimer += 1000;
				janela.setTitle(nome+" FPS:"+ticks);
				ticks = 0;
			}
			
			try {
				Thread.sleep(ticks/1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		 new Main();
	}

}
