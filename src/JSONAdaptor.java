import java.lang.reflect.Type;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JSONAdaptor {
	Gson gson = new Gson();
	JsonReader reader;
	ArrayList<StockData> sdArray;
	private static final Type STOCKDATA_TYPE = new TypeToken<ArrayList<StockData>>() {
	}.getType();
	public JSONAdaptor(String filePath) {
		try {
		this.reader = new JsonReader(new FileReader(filePath));
		}catch (Exception e) {
		    e.printStackTrace();
	    }
	}
	public ArrayList<StockData> createStockDataArray() {
		this.sdArray = gson.fromJson(reader, STOCKDATA_TYPE);
		return sdArray;
	}
}
