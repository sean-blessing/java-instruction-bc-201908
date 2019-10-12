
public class AlternatePlayerApp {

	public static void main(String[] args) {
		System.out.println("hi");
		
		int player = 1;
		int count = 10;
		for (int i=1; i < count; i++) {
			System.out.println("Player"+player+"'s turn!");
			if (player==1) player = 2;
			else if (player==2) player = 1;
		}
		
		
		System.out.println("bye");

	}

}
