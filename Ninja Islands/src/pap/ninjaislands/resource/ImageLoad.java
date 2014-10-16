package pap.ninjaislands.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoad {
	
	/*
	 * @autor Carlos Almeida
	 */

	public static BufferedImage ilhas;
	public static BufferedImage ninja;
	
	public ImageLoad(){
		try {
			ilhas = ImageIO.read(getClass().getResource("/ilhas.png"));
			ninja = ImageIO.read(getClass().getResource("/ninja.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
