import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the table of powers app!!");

		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		int c = 0;
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter a whole number: ");
			int n = sc.nextInt();
			System.out.println("Number\tSquared\tCubed");
			System.out.println("======\t=======\t=====");
			for (int i=1; i<=n; i++) {
				System.out.println(i + "\t"+ i*i + "\t" + i*i*i);
			}
			c++;  // increment counter
			System.out.println("You have played "+c+" times.");
			System.out.println("Continue??");
			choice = sc.next();
		}
		
		sc.close();
		System.out.println("Bye!");
	}

}
