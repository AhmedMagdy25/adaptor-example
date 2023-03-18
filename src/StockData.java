
public class StockData {
	private String name;
	private String company;
	private String description;
	private float initial_price;
	private float price_2002;
	private float price_2007;
	private String symbol;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInitial_price(float initial_price) {
		this.initial_price = initial_price;
	}

	public void setPrice_2002(float price_2002) {
		this.price_2002 = price_2002;
	}

	public void setPrice_2007(float price_2007) {
		this.price_2007 = price_2007;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "StockData [name=" + name + ", company=" + company + ", description=" + description + ", initial_price="
				+ initial_price + ", price_2002=" + price_2002 + ", price_2007=" + price_2007 + ", symbol=" + symbol
				+ "]";
	}

	
	
	
}
