package pap.ninjaislands.mechanics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Debug {

	public static void Print(String text){
		File ficheiro = new File("Debug.txt");
		FileWriter escrever;
		try {
			escrever = new FileWriter(ficheiro, true);
			BufferedWriter bufferedWriter = new BufferedWriter(escrever);
			bufferedWriter.write("Ninjas vs Zombie Pirates Debug:"+text+"\n");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
