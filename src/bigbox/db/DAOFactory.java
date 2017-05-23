package bigbox.db;
public class DAOFactory {
	public static StoreDAO getStoreDAO(){
		StoreDAO storeDAO = new StoreArray();
		return storeDAO;
	}
		

}
