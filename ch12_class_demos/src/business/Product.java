package business;

public class Product {

	private String code;
	private String decscription;
	private double price;
	public Product(String code, String decscription, double price) {
		super();
		this.code = code;
		this.decscription = decscription;
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDecscription() {
		return decscription;
	}

	public void setDecscription(String decscription) {
		this.decscription = decscription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double p) {
		price = p;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", decscription=" + decscription + ", price=" + price + "]";
	}
	
}
