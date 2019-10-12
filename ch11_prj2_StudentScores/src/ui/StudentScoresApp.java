package ui;

import java.util.Arrays;

import business.Student;
import util.Console;


public class StudentScoresApp {

	public static void main(String[] args) {
//		Student s1 = new Student();
//		Student s2 = new Student("fname","Lname",88);
		System.out.println("Welcome to the Student Scores App");

		int nbr = Console.getInt("How many students?", 0, 501);
		
		Student[] students = new Student[nbr];
		
		for (int i=0; i < nbr; i++) {
			String lastName = Console.getString("Student Last Name:  ");
			String firstName = Console.getString("Student First Name:  ");
			int score = Console.getInt("Score:  :", -1, 101);
			Student s = new Student(firstName,lastName,score);
			students[i] = s;
		}
		
		System.out.println("SUMMARY");
		Arrays.sort(students);
		for (Student s: students) {
			System.out.println(s);
		}
		
		System.out.println("Bye");
	}

}
