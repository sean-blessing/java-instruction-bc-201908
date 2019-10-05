
public class ThisKeywordApp {

	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		String code = Console.getString("Enter a code: ");
		String desc = Console.getLine("Enter a description: ");
		double price = Console.getDouble("Enter a price: ");
		Product p = new Product(code, desc, price);
		
		System.out.println(p);

	}

}
