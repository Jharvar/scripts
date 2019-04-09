package scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class script {
	
	private BufferedReader br;
	
	public void extractInFile(String path) {
		try {
			br = new BufferedReader(new FileReader(path));
			String line ="";
			while((line= br.readLine())!=null) {
				token(line);
			}
			
		}catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getLocalizedMessage());
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void token(String line) {
		StringTokenizer token = new StringTokenizer(line, "#");
		while(token.hasMoreTokens()) {
			String result = token.nextToken();
			System.out.println(result);
			writeIntoTheNewFile(result);
		}
	}
	public void writeIntoTheNewFile(String result) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("./ficheros/valor.txt"));
			bw.write(result);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
	}
}
