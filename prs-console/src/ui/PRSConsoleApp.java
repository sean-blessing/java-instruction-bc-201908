package ui;

import util.Console;

public class PRSConsoleApp {

	public static void main(String[] args) {
		System.out.println("PRS Console\n");
		
		int command = 0;
		while (command!=6) {
			command = Console.getInt(getMenu(), 0, 7);
			
			switch (command) {
			case 1:
				// list users
				break;
			case 2:
				// get a user
				break;
			case 3:
				// add a user
				break;
			case 4:
				// update a user
				break;
			case 5:
				// delete a user
				break;
			case 6:
				// list users
				break;
			default:
				// invalid command
				System.out.println("Invalid command.");
				break;

			}
			
		}
		
		
		
		System.out.println("Bye");
	}
	
	private static String getMenu() {
		String menu = "COMMAND MENU:\n"+
					  "1 - User List\n" +
					  "2 - Get User\n" +					  
					  "3 - Add User\n" +
					  "4 - Edit User\n" +
					  "5 - Delete User\n" +
					  "6 - Exit\n" +
					  "Command:  ";
		return menu;
	}

}
