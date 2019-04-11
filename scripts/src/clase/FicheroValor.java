package clase;

import java.util.ArrayList;

public class FicheroValor implements FicheroListInterface {

	private ArrayList<String> listValue;
	
	public FicheroValor() {
		listValue = new ArrayList<String>();
	}

	public ArrayList<String> getListValue() {
		return listValue;
	}

	public void setListValue(ArrayList<String> listValue) {
		this.listValue = listValue;
	}

	@Override
	public void add(String key) {
		listValue.add(key);
		
	}

	@Override
	public void setKey(int i,String key) {
		listValue.set(i, key);
		
	}

	@Override
	public String getKey(int i) {
		return listValue.get(i);
	}

	@Override
	public void listKeys() {
		for (String keys : listValue) {
			System.out.println(keys);
		}
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listValue.size();
	}
	
}
