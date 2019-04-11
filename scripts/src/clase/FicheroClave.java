package clase;

import java.util.ArrayList;

public class FicheroClave implements FicheroListInterface {
	
	private ArrayList<String> listaString ;
	
	public FicheroClave() {
		listaString = new ArrayList<>();
		
	}

	public ArrayList<String> getListaString() {
		return listaString;
	}

	public void setListaString(ArrayList<String> listaString) {
		this.listaString = listaString;
	}

	@Override
	public void add(String key) {
		listaString.add(key);
		
	}

	@Override
	public void setKey(int i, String key) {
		listaString.set(i, key);
		
	}

	@Override
	public String getKey(int i) {
		return listaString.get(i);
	}

	@Override
	public void listKeys() {
		for (String value : listaString) {
			System.out.println(value);
		}
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listaString.size();
	}
	
	
	
}
