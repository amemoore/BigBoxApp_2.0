package bigbox.db;

import java.util.ArrayList;
import java.util.Scanner;
import bigbox.business.Store;
import bigbox.util.Validator;

public class StoreArray implements StoreDAO{
	
	//class variable
	private ArrayList<Store> stores;
	Scanner sc = new Scanner(System.in);
	
	//constructor
	public StoreArray()
	{
		stores = getAllStores();
	}
	@Override
	public ArrayList<Store> getAllStores()
	{
		if (stores == null)
		setupStoresArray();
		return stores;
	}
	private void setupStoresArray() {
		stores = new ArrayList<>();
		stores.add(new Store(1,"Mason BigBox","5711 Fields Ertel Rd.", "Mason", "OH","45249","001","00011","25000"));
		stores.add(new Store(2,"Downtown BigBox","9330 Main St.", "Cincinnati", "OH","45202","001","00255","27500"));
		stores.add(new Store(3,"Goshen BigBox","6777 Goshen Rd.", "Goshen", "OH","45122","001","00172","32555.55"));
		stores.add(new Store(4,"Bridgetown BigBox","3888 Race Rd.", "Cincinnati", "OH","45211","001","00075","21425.37"));
		stores.add(new Store(5,"Louisville BigBox","1111 Washington St.", "Louisville", "KY","40206","111","00001","14432.77"));
		stores.add(new Store(6,"Lawrenceburg BigBox","8000 Liberty St.", "Louisville", "KY","40204","111","00044","17555.11"));
	}
	public static String displayMenuAndPrompt(Scanner sc,String prompt)
	{
		Validator.displayMenu();
		String operation = Validator.getString(sc, "Enter a command:  ");
		return operation;
	}
	@Override
	public void addStore() {
		int id = Validator.getInt(sc, "Enter id number:  ");
		String divNo = Validator.getStringNumeric(sc, "Enter division number:  ", 3);
		String strNo = Validator.getStringNumeric(sc, "Enter store number:  ", 5);
		String sales = Validator.getString(sc, "Enter sales:  ");
		String name = Validator.getString(sc, "Enter store name:  ");
		String address = Validator.getString(sc, "Enter store address:  ");
		String city = Validator.getString(sc, "Enter store city:  ");
		String state = Validator.getString(sc, "Enter store state:  ");
		String zip = Validator.getString(sc, "Enter store zip:  ");
		stores.add(new Store(id, name, address, city, state, zip, divNo, strNo, sales));
	}
	public  ArrayList<Store> listStores() {
		
		for (int i = 0; i<stores.size(); i++)
		{
			System.out.println(stores.get(i));
		}
		return stores;
	}
	@Override
	public boolean deleteStore(Store dStore) {

		return stores.remove(dStore);
	}
	@Override
	public Store getAllStoresByDivision() {
		
		String divNo = Validator.getStringNumeric(sc, "Enter division number:  ", 3);
		Store store = null;	
			
		for (Store s: stores)
			{
				if (s.getDivNo().equals(divNo))
				{
					store = s;
					System.out.println(store);
				}
			}
			return store;
	}
	@Override
	public Store getStoreByDivisionAndStoreNumber() 
	{
		Store store=null;

		String divNo = Validator.getStringNumeric(sc, "Enter division number:  ", 3);
		String strNo = Validator.getStringNumeric(sc, "Enter store number:  ", 5);
		
		for (Store s: stores)
		{
			if ((s.getDivNo().equals(divNo) && (s.getStrNo().equals(strNo))))
				store = s;
		}
	return store;
	}
}
