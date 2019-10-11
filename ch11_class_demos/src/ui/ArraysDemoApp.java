package ui;

import java.util.Arrays;

public class ArraysDemoApp {

	public static void main(String[] args) {
		double[] prices = new double[4];
		prices[0] = 14.95;
		prices[1] = 12.95;
		prices[2] = 11.95;
		prices[3] = 9.95;
		
		for (int i=0; i < prices.length; i++) {
			System.out.println(i+ ":"+ prices[i]);			
		}
		
		String[] students = {"Brytt", "Anthony", "Joelle", "Fred",
							"Karlee", "Justin"};
		
		System.out.println("Print array of students - old school for");
		for (int i=0; i< students.length; i++) {
			System.out.println(i + ":"+ students[i]);
		}
		
		System.out.println("for each loop of prices");
		for (double p: prices) {
			System.out.println(p);
		}
		
		String[] letters = new String[10];
		Arrays.fill(letters, "a");
		
		for (String str: letters) {
			System.out.println(str);
		}
		
		// sort array of students
		System.out.println("Sorted students:");
		Arrays.sort(students);
		for (String student: students) {
			System.out.println(student);
		}
		
		System.out.println("sorted prices:");
		Arrays.sort(prices);
		for (double p: prices) {
			System.out.println(p);
		}
		
		System.out.println("comparing arrays, copying");
		int[] numbers1 = {4,7,2,5,0};
		int[] numbers2 = numbers1;
		int[] numbers3 = Arrays.copyOf(numbers1, 5);
		
		System.out.println(Arrays.equals(numbers1, numbers2));
		
		numbers1[1] = 100;
		System.out.println("numbers1");
		for (int i: numbers1) {
			System.out.println(i);
		}
		System.out.println("numbers2");
		for (int i: numbers2) {
			System.out.println(i);
		}
		System.out.println("numbers3");
		for (int i: numbers3) {
			System.out.println(i);
		}
		

	}

}
