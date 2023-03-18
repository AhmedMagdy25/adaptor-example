import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLAdaptor {
	private File file;
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document document;
	private StockData sd;
	ArrayList<StockData> sdArray = new ArrayList<StockData>();
	
	public XMLAdaptor(String filePath) {
		try {
			this.file = new File(filePath);
			this.dbf = DocumentBuilderFactory.newInstance();
			this.db = dbf.newDocumentBuilder();
			this.document = db.parse(file);
			this.document.getDocumentElement().normalize();
		}catch (Exception e) {
		    e.printStackTrace();
	    }
	}
	public ArrayList<StockData> createStockDataArray() {
		NodeList nodes = document.getDocumentElement().getChildNodes();
		int stockLength = nodes.getLength();
		for(int itemNum = 1; itemNum < stockLength-1; itemNum++) {
			NodeList childNodes = nodes.item(itemNum).getChildNodes();
			if(nodes.item(itemNum).getNodeName() != "#text") {
				this.sd = new StockData();
				 sd.setName(nodes.item(itemNum).getNodeName());
				for(int childNum = 1; childNum < childNodes.getLength(); childNum++) {
					if(childNodes.item(childNum).getNodeName() != "#text") {
						if(childNodes.item(childNum).getNodeName() == "company")
							sd.setCompany(childNodes.item(childNum).getTextContent());
						else if(childNodes.item(childNum).getNodeName() == "description")
							sd.setDescription(childNodes.item(childNum).getTextContent());
						else if(childNodes.item(childNum).getNodeName() == "initial_price")
							sd.setInitial_price(Float.parseFloat(childNodes.item(childNum).getTextContent()));
						else if(childNodes.item(childNum).getNodeName() == "price_2002")
							sd.setPrice_2002(Float.parseFloat(childNodes.item(childNum).getTextContent()));
						else if(childNodes.item(childNum).getNodeName() == "price_2007")
							sd.setPrice_2007(Float.parseFloat(childNodes.item(childNum).getTextContent()));
						else if(childNodes.item(childNum).getNodeName() == "symbol")
							sd.setSymbol(childNodes.item(childNum).getTextContent());
					}
				}
				sdArray.add(sd);
			}
		}
		return  sdArray;
	}
}
