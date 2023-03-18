import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		XMLAdaptor xmlAdaptor = new XMLAdaptor("./StockData.xml");
		ArrayList<StockData> sdArrayfromXML =  xmlAdaptor.createStockDataArray();
		for(int i = 0; i < sdArrayfromXML.size(); i++) {
			System.out.println(sdArrayfromXML.get(i).toString());
		}
		
		JSONAdaptor jsonAdaptor = new JSONAdaptor("./StockData.json");
		ArrayList<StockData> sdArrayfromJSON =  jsonAdaptor.createStockDataArray();
		for(int i = 0; i < sdArrayfromJSON.size(); i++) {
			System.out.println(sdArrayfromJSON.get(i).toString());
		}
	}
}
