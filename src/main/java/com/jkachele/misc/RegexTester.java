package com.jkachele.personal;

import java.util.*;

public class RegexTester {

	public static void main(String[] args) {
		splitArray();
	}
	
	public static void test() {
		Scanner input = new Scanner(System.in);
		
		String regex = "[A-Z][A-Za-z]*";
		String loop;
		
		do {
			System.out.println("Enter String to be tested");
			String test = input.nextLine();
		
			System.out.println((test.matches(regex)? "Test matches regex" : "Test does not match regex"));
			
			System.out.print("Try Again?(y/n)");
			loop = input.nextLine();
			System.out.println();
			
		}while(loop.equalsIgnoreCase("y"));
		
		System.out.println("Goodbye!");
		input.close();
	}
	
	public static void splitTest() {
		Scanner input = new Scanner(System.in);
		
		String regex = "[A-Z][A-Za-z]*";
		String loop;
		
		do {
			System.out.println("Enter String to be tested");
			String test = input.nextLine();
		
			String[] list = test.split(" ");
			
			for(String i: list) {
				if(i.matches(regex))
					System.out.println(i);
			}
			
			System.out.print("Try Again?(y/n)");
			loop = input.nextLine();
			System.out.println();
			
		}while(loop.equalsIgnoreCase("y"));
		input.close();
		
	}
	
	public static void splitArray() {
		Scanner input = new Scanner(System.in);
		String loop;
		
		do {
			System.out.println("Enter String to be tested");
			String test = input.nextLine();
			
			String[] array = test.split(" ");
			System.out.print("[");
			for(String i: array) {
				String[] temp = i.split("((?<=\\D)|(?=\\D))");
				for(String j: temp) {
					//list.add(i);
					System.out.print(j+", ");
				}
			}
			
			System.out.println("]");
			//System.out.println(list);
			
			System.out.print("Try Again?(y/n)");
			loop = input.nextLine();
			System.out.println();
			
		}while(loop.equalsIgnoreCase("y"));
		input.close();
	}

}
