package pap.ninjaislands.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pap.ninjaislands.resource.ImageLoad;
import pap.ninjaislands.world.GameMap;

public class Main implements Runnable{

	JFrame janela;
	
	private String nome = "Ninja vs Zombie Pirates - Prototipo";
	
	//comprimento do ecra
	private int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	//largura do ecra
	private int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static int ZOOM = 4;
	
	public static double OFFSETX = 0;
	public static double OFFSETY = 0;
	
	public boolean isRunning = false;//estado do jogo: true = jogar false = pausa
	
	Image screen; //vai servir para não se notar as transaçoes das frames
	GameMap gamemap;
	
	public Main(){
		janela = new JFrame();//inicializar
		janela.setTitle(nome); //definir nome da janela 
		janela.setSize(WIDTH, HEIGHT); //definir tamanho da janela
		janela.setResizable(false); //false = nao permitir mudar resolução da janela
		janela.setLocationRelativeTo(null); //centrar janela no ecra
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fechar corretamente a janela
		janela.setVisible(true);
		
		new ImageLoad();
		gamemap = new GameMap(0, HEIGHT/2/ZOOM+ZOOM, 188 * ZOOM, 27 * ZOOM);
		
		isRunning = true;
		new Thread(this).start();
	}
	
	public void tick(){
		//logicas
	}
	
	public void render(){
		//graficos
		Graphics g = screen.getGraphics(); //inicialização
		//Fundo/ceu
		g.setColor(new Color(153, 217, 234)); //definir cor em RGB
		g.fillRect(0, 0, WIDTH, HEIGHT); //desenhar retangulo preenchido
		
		//mapa
		gamemap.render(g);
		
		//mar
		g.setColor(new Color(0, 162, 232, 225));
		g.fillRect(0, HEIGHT/ZOOM - 11 * ZOOM, WIDTH, 11*ZOOM);
		
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
		}
	}
	
	public static void main(String[] args) {
		 new Main();
	}

}
