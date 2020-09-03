package ui;

public class TernaryOperatorApp {

	public static void main(String[] args) {
		int num = 8;
		String msg = "";
		if(num > 10) {
		    msg = "Number is greater than 10";
		}
		else {
		    msg = "Number is less than or equal to 10";
		}
		System.out.println(msg);
		
		msg = num < 8 ? "Number is less than 8" :
			"number is greater than or equal to 8";
		System.out.println(msg);
		
		
		boolean even = (num % 2 == 0) ? true : false;
		System.out.println(" is even? "+even);
	}

}
