package com.jkachele.misc;
/*
 * 
 * Author: Justin Kachele
 * 
 */
import java.util.Scanner;
import java.util.Random;

public class InsultGenerator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		Random randGen = new Random ();
		
		String c = "Y";
		
		do {
			System.out.println("Welcome to the Insult Generator!");
			System.out.print("Enter Person's name: ");
			switch(randGen.nextInt(10)) {
				case 0:
					System.out.println("");
					break;
				case 1:
					System.out.println("");
					break;
				case 2:
					System.out.println("");
					break;
				case 3:
					System.out.println("");
					break;
				case 4:
					System.out.println("");
					break;
				case 5:
					System.out.println("");
					break;
				case 6:
					System.out.println("");
					break;
				case 7:
					System.out.println("");
					break;
				case 8:
					System.out.println("");
					break;
				case 9:
					System.out.println("");
					break;
			}
		
			System.out.print("Comtinue? (y/n): ");
			c = input.next();
			
		}while(c.equalsIgnoreCase("Y"));
		input.close();
	}

}
