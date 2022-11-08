package com.jkachele.personal;
import java.util.Scanner;
import java.util.Random;

public class RandomGenerator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int opp;
		boolean cont = true;
		
		do {
			System.out.println("Welcome to The Random Case Generator!\n");
			System.out.println("Choose a Case:\n1. Coin Toss\n2. Dice Roll\n3. Card Draw\n4. Random Integer\n5. Quit");
			opp = input.nextInt();
			
			switch(opp) {
				case 1:
					coin();
					break;
				case 2:
					dice();
					break;
				case 3:
					card();
					break;
				case 4:
					randN();
					break;
				case 5:
					System.out.println("Goodbye!");
					cont = false;
					break;
			}

		}while(cont);
		input.close();

	}
	
	public static void coin() {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int curr, heads = 0, tails = 0;
		char cont = 'y';
		boolean isHeads;
		
		do {
			curr = rand.nextInt(2);
			if(curr == 1) {
				isHeads = true;
				++heads;
			}
			else {
				isHeads = false;
				++tails;
			}
			
			if(isHeads)
				System.out.println("Toss was a Heads");
			else
				System.out.println("Toss was a Tails");
			
			System.out.printf("Heads: %d, Tails: %d\n\n", heads, tails);
			
			System.out.print("Flip Again?(y/n): ");
			cont = input.next().charAt(0);
			System.out.println();
			
		}while(cont != 'n');
		input.close();
	}
	
	public static void dice() {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int face;
		char cont = 'y';
		
		do {
			face = 1 + rand.nextInt(6);
			
			switch(face) {
				case 1:
					++count1;
					break;
				case 2:
					++count2;
					break;
				case 3:
					++count3;
					break;
				case 4:
					++count4;
					break;
				case 5:
					++count5;
					break;
				case 6:
					++count6;
					break;
			}
			
			System.out.println("Current roll is: "+face);
			System.out.printf("Archive:\n1) %d\n2) %d\n3) %d\n4) %d\n5) %d\n6) %d\n\n", count1, count2, count3, count4, count5, count6);
			
			System.out.print("Roll Again?(y/n): ");
			cont = input.next().charAt(0);
			System.out.println();
			
		}while(cont != 'n');
		input.close();
	}
	
	public static void card() {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int suitN, number;
		char cont = 'y';
		String suit = null;
		String value = null;
		
		do {
			suitN = rand.nextInt(4);
			number = rand.nextInt(13);
			
			switch(suitN) {
				case 0:
					suit = "Spades";
					break;
				case 1:
					suit = "Clubs";
					break;
				case 2:
					suit = "Diamonds";
					break;
				case 3:
					suit = "Hearts";
					break;
			}
			switch(number) {
				case 0:
					value = "ace";
					break;
				case 1:
					value = "2";
					break;
				case 2:
					value = "3";
					break;
				case 3:
					value = "4";
					break;
				case 4:
					value = "5";
					break;
				case 5:
					value = "6";
					break;
				case 6:
					value = "7";
					break;
				case 7:
					value = "8";
					break;
				case 8:
					value = "9";
					break;
				case 9:
					value = "10";
					break;
				case 10:
					value = "Jack";
					break;
				case 11:
					value = "Queen";
					break;
				case 12:
					value = "King";
					break;
			}
			
			System.out.println("\nRandom Card: "+value+" of "+suit);
			
			System.out.print("\nDraw Another Card?(y/n): ");
			cont = input.next().charAt(0);
			System.out.println();
			
		}while(cont != 'n');
		input.close();
		
	}
	
	public static void randN() {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int bot, top, num, range, contN;
		boolean cont = true;
		boolean keepBound = true;
		
		
		do {
			System.out.print("\nEnter Lowest Number: ");
			bot = input.nextInt();
			System.out.print("Enter Highest Number: ");
			top = input.nextInt();
			
			if (bot >= top) {
				System.out.println("\nHighest number muse be larger than lowest number");
				continue;
			}
			
			range = 1 + top - bot;
			
			do {
				num = bot + rand.nextInt(range);
				
				System.out.printf("\nRandom Number Between %d and %d is %d\n\n", bot, top, num);
				
				System.out.println("Continue?\n1. With Same Bounds\n2. With Different Bounds\n3. Quit");
				contN = input.nextInt();
				
				switch(contN) {
					case 1:
						cont = true;
						keepBound = true;
						break;
					case 2:
						cont = true;
						keepBound = false;
						break;
					case 3:
						cont = false;
						keepBound = false;
						break;
				}

			}while(keepBound);

		}while(cont);
		input.close();
		
	}

} 