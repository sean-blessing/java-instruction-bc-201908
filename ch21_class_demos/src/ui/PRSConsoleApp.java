package ui;

import java.sql.SQLException;
import java.util.List;

import business.User;
import db.UserDB;
import util.Console;

public class PRSConsoleApp {
	private static UserDB udb = new UserDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS Console");
		
		int command = 0;
		while (command != 99) {
			command = Console.getInt(getMenuDisplay(),0,100);
			switch (command) {
			case 1:
				//list
				try {
					List<User> users = udb.list();
					System.out.println("List of users:");
					for (User u: users) {
						System.out.println(u);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				// get
				int id = Console.getInt("User ID:  ");
				try {
					User u = udb.get(id);
					System.out.println("User retrieved: ");
					System.out.println(u);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				// add
				System.out.println("Add a user:");
				String un = Console.getString("Username? ");
				String pwd = Console.getString("Pwd? ");
				String fn = Console.getString("First Name? ");
				String ln = Console.getString("Last Name? ");
				String phone = Console.getString("PhoneNumber? ");
				String email = Console.getString("Email? ");
				boolean rvw = false;
				boolean adm = false;
				User u = new User(un, pwd, fn, ln, phone, email, rvw, adm);
				int rowCount = 0;
				rowCount = udb.addUser(u);
				System.out.println("User add, "+rowCount+" rows affected.");
				break;
			case 4:
				// update
				// 1 - get the id of the user we want to update
				System.out.println("Get a user:");
				int uid = Console.getInt("User Id?: ");
				// 2 - get the user for the id entered
				u = getUser(uid);
				if (u == null) {
					// 3 - does the user exist?  if not, error
					System.out.println("No user found for id: "+uid);
				}
				else {
					// 4 - if user exists, prompt for new email address
					String newEmail = Console.getString("New email address?: ");
					// 5 - update the email address in user
					u.setEmail(newEmail);
					// 6 - update user
					rowCount = udb.updateUser(u); 
					if (rowCount==1) {
						System.out.println("User updated.");
					}
					else {
						System.out.println("Error updating user.");
					}
				}
				break;
			case 5:
				// delete
				// 1 - get the id of the user we want to delete
				System.out.println("Get a user:");
				uid = Console.getInt("User Id?: ");
				// 2 - get the user for the id entered
				u = getUser(uid);
				if (u == null) {
					// 3 - does the user exist?  if not, error
					System.out.println("No user found for id: "+uid);
				}
				else {
					// 4 - delete user
					rowCount = udb.deleteUser(u); 
					if (rowCount==1) {
						System.out.println("User deleted.");
					}
					else {
						System.out.println("Error deleting user.");
					}
				}

				break;
			case 99:
				// exit
				break;
			default:
				System.out.println("Error.  Invalid Command.");
				break;
			}
		}
		
		System.out.println("Bye");

	}
	
	private static String getMenuDisplay() {
		String str = "MENU\n"+
					 "1  - List Users\n"+
					 "2  - Get User\n"+
					 "3  - Add User\n"+
					 "4  - Update User\n"+
					 "5  - Delete User\n"+
					 "99 - Exit\n"+
					 "Command: ";
		return str;
	}
	
	private static User getUser(int id) {
		User u = null;
		try {
			u = udb.get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		
	}

}
