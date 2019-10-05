
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
	
	public void setPrice(double p) {
		price = p;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", decscription=" + decscription + ", price=" + price + "]";
	}
	
}
