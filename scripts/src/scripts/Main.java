package scripts;

import java.io.IOException;

import clase.FileRead;

public class Main {

	public static void main(String[] args) {
		try {
			FileRead fr = new FileRead();
			fr.SepararFichero("./ficheros/fichero.txt");
			fr.writeIntoTheNewFile();
			fr.joinFiles();
			fr.showProperties();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
