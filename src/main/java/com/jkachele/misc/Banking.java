package com.jkachele.misc;
/*
 * 
 * Author: Justin Kachele
 * 
 */
import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		char select,selectA,selectB,selectC;
		double deposit,withdraw;
		double checking = 0;
		double savings = 0;
		String c = "Y";
		boolean funds = true;
		
		do {
		
			System.out.println("Welcome to the Java Bank");
			System.out.printf("\n %s \n %s \n %s \n %s \n","Choose Action","a) View Balence", "b) Deposit", "c) Withdraw");
			select = input.next().charAt(0);
			
			switch(Character.toLowerCase(select)) {
				case 'a':
					System.out.printf("\n %s \n %s \n %s \n %s \n","Choose Account","a) Checking", "b) Savings", "c) Both");
					selectA = input.next().charAt(0);
					switch(Character.toLowerCase(selectA)) {
						case 'a':
							System.out.printf("Checking Balence: %.2f\n", checking);
							break;
						case 'b':
							System.out.printf("Savings Balence: %.2f\n", savings);
							break;
						case 'c':
							System.out.printf("Checking Balence: %.2f\n", checking);
							System.out.printf("Savings Balence: %.2f\n", savings);
							break;
						default:
							System.out.println("invalid Input");
							break;
					}
					break;
				case 'b':
					System.out.printf("\n %s \n %s \n %s \n","Choose Account","a) Checking", "b) Savings");
					selectB = input.next().charAt(0);
					switch(Character.toLowerCase(selectB)) {
						case 'a':
							System.out.print("Amount to be Deposited: ");
							deposit = input.nextDouble();
							checking += deposit;
							System.out.printf("New Balence: %.2f\n", checking);
							break;
						case 'b':
							System.out.print("Amount to be Deposited: ");
							deposit = input.nextDouble();
							savings += deposit;
							System.out.printf("New Balence: %.2f\n", savings);
							break;
						default:
							System.out.println("invalid Input");
							break;
					}
					break;
				case 'c':
					System.out.printf("\n %s \n %s \n %s \n","Choose Account","a) Checking", "b) Savings");
					selectC = input.next().charAt(0);
					switch(Character.toLowerCase(selectC)) {
						case 'a':
							do {
								funds = true;
								System.out.print("Amount to be Withdrawn: ");
								withdraw = input.nextDouble();
								if(withdraw > checking) {
									System.out.println("Funds Insufficient");
									System.out.printf("Checking Balence: %.2f\n", checking);
									funds = false;
								}
								else {
									checking -= withdraw;
									System.out.printf("New Balence: %.2f\n", checking);
								}
							}while(funds == false);
							break;
						case 'b':
							do {
								funds = true;
								System.out.print("Amount to be Withdrawn: ");
								withdraw = input.nextDouble();
								if(withdraw > savings) {
									System.out.println("Funds Insufficient");
									System.out.printf("Savings Balence: %.2f\n", savings);
									funds = false;
								}
								else {
									savings -= withdraw;
									System.out.printf("New Balence: %.2f\n", savings);
								}
							}while(funds == false);
							break;
						default:
							System.out.println("invalid Input");
							break;
					}
					break;
				default:
					System.out.println("invalid Input");
					break;
			}
			
			System.out.print("\nContinue? (Y/N): ");
				c = input.next();
			System.out.println("");
			
		}while(c.equalsIgnoreCase("Y"));
		input.close();
	}

}