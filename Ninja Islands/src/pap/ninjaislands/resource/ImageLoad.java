package pap.ninjaislands.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoad {

	public static BufferedImage ilhas;
	
	public ImageLoad(){
		try {
			ilhas = ImageIO.read(getClass().getResource("/ilhas.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
