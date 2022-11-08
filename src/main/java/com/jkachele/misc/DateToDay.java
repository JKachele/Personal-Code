package com.jkachele.personal;
/*
 * 
 * Author: Justin Kachele
 * 
 */
import java.util.Scanner;

public class DateToDay {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int day,monthIn,monthForm,yearInp,yearForm,century,week1,week2;
		String dow = null;
		boolean checkDate = true;
		
		//do{
		while(true) {
		
		checkDate = true;
		
		System.out.print("Enter Day(1-31): ");
		day = input.nextInt();
		System.out.print("Enter Month(1-12): ");
		monthIn = input.nextInt();
		System.out.print("Enter Year: ");
		yearInp = input.nextInt();

		input.close();
		
		if (monthIn <= 0 || monthIn >= 13 || day <= 0 || day >= 32)
			checkDate = false;
		
		switch (monthIn) {
			case 2:
				if (((yearInp % 4 == 0 && yearInp % 100 != 0) || yearInp % 400 == 0) && (day <= 0 || day >= 30))
						checkDate = false;
				else
					if ((yearInp % 4 != 0 || (yearInp % 400 != 0 && yearInp % 100 == 0)) && (day <= 0 || day >= 29))
						checkDate = false;
				break;
			case 4:
				if (day <= 0 || day >= 31)
					checkDate = false;
				break;
			case 6:
				if (day <= 0 || day >= 31)
					checkDate = false;
				break;
			case 9:
				if (day <= 0 || day >= 31)
					checkDate = false;
				break;
			case 11:
				if (day <= 0 || day >= 31)
					checkDate = false;
				break;
		}
		
		if (checkDate == true) {
		
			monthForm = 0;
			if (monthIn >= 3 && monthIn <=12) 
				monthForm = monthIn-2;
			else
				if (monthIn == 1 || monthIn == 2)
					monthForm = monthIn + 10;
			
			yearForm = 0;
			if (monthIn == 1 || monthIn == 2)
				yearForm = yearInp % 100 - 1;
			else
				yearForm = yearInp % 100;
			
			century = (yearInp / 100) % 100;
			
			week1 = (int) (day + (Math.floor(2.6 * monthForm - 0.2)) - 2 * century + yearForm + (Math.floor(yearForm / 4)) + (Math.floor(century / 4))) % 7;
			
			if (week1 < 0)
				week2 = week1 + 7;
			else
				week2 = week1;
			
			switch (week2) {
				case 0:
					dow = "Sunday";
					break;
				case 1:
					dow = "Monday";
					break;
				case 2:
					dow = "Tuesday";
					break;
				case 3:
					dow = "Wednesday";
					break;
				case 4:
					dow = "Thursday";
					break;
				case 5:
					dow = "Friday";
					break;
				case 6:
					dow = "Saturday";
					break;
			}
			
			System.out.printf("\n%d/%d/%d is a %s\n",monthIn,day,yearInp,dow);
			}
		else
			System.out.println("\nInvalid Date");
		
		//System.out.print("\nContinue? (Y/N): ");
		//c = input.next();
		System.out.println("");
		
		//}while(c.equalsIgnoreCase("Y"));
		}

		
		
	}

}
