package ui;

import java.util.ArrayList;
import java.util.List;

import business.Contact;

public class ContactLambdaApp {

	public static void main(String[] args) {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Jim Brown", null, null));
		contacts.add(new Contact("George Smith", "g@smith.com","555-555-5555"));
		contacts.add(new Contact("Karlee Hambone", null, "444-444-4444"));
		
		System.out.println("for loop");
		for (Contact c: contacts) {
			System.out.println(c);
		}
		
		System.out.println("Stream foreach");
		contacts.stream().forEach(c -> System.out.println(c));
		
		System.out.println("filter contacts - no email");
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact c: contacts) {
			if (c.getEmail()==null) {
				filteredContacts.add(c);
			}
		}
		
		for (Contact c: filteredContacts) {
			System.out.println(c);
		}
		
		System.out.println("Stream and lambdas - contacts no email");
		contacts.stream().filter(c -> c.getEmail()==null).forEach(c -> System.out.println(c));
	}

}
