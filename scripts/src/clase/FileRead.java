package clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {

	
	
	private BufferedReader br;
	private FicheroValor fv;
	private FicheroClave fc;
	private final static String SEPARATOR ="=#";
	
	public FileRead() throws IOException {
		fv = new FicheroValor();
		fc = new FicheroClave();
	}
	
	public void SepararFichero(String path) {
		try {
			br = new BufferedReader(new FileReader(path));
			String linea = "";
			String lineaRecogida="";
			while((linea=br.readLine())!=null) {
				if(linea.contains(SEPARATOR)) {
					int pos = linea.indexOf("=");
					lineaRecogida = linea.substring(0, pos);
					fc.add(lineaRecogida);
					lineaRecogida = linea.substring(pos+2);
					fv.add(lineaRecogida);
				}
			}
			
			br.close();
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void showProperties() {
		fc.listKeys();
		fv.listKeys();
	}
	
	public void writeIntoTheNewFile() {
		try {
			BufferedWriter bKey = new BufferedWriter(new FileWriter(new File("./key.txt")));
			BufferedWriter bValue=new BufferedWriter(new FileWriter(new File("./value.txt")));
			for (int i = 0; i < fc.getSize(); i++) {
				bKey.write(fc.getKey(i)+"\n");
				bValue.write(fv.getKey(i)+"\n");
			}
			
			bKey.close();
			bValue.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void joinFiles() {
		try {
			String joinProperties ="";
			BufferedWriter bproperties = new BufferedWriter(new FileWriter(new File("./join.txt")));
			for (int i = 0; i < fc.getSize(); i++) {
				joinProperties= fc.getKey(i)+"=#"+fv.getKey(i);
				bproperties.write(joinProperties);
				bproperties.write("\n");
			}
			bproperties.close();
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
