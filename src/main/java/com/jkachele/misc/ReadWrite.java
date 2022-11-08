package com.jkachele.misc;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.File;

public class ReadWrite {

	public static void main(String[] args) throws Exception {
		Scanner userIn = new Scanner(System.in);
		
		int opp;
		String invalid;
		boolean cont = true;
		String file = "test.txt";
		
		while(cont) {
			while(true) {
				System.out.printf("%s\n%s\n%s", "Enter Number of wanted opperation", "1) Add entry to file, 2) Remove entry from file, 3) Display File Contents, 4) Quit", "? ");
				if(userIn.hasNextInt()) {
					opp = userIn.nextInt();
					if(opp >= 1 && opp <= 4)
						break;
					else
						System.out.print("\""+opp+"\" is an invalid input, enter integers from 1 to 4\n? ");
				}
				else {
					invalid = userIn.nextLine();
					System.out.print("\""+invalid+"\" is an invalid input, enter integers from 1 to 4\n? ");
				}
			}
			switch(opp){
				case 1:
					write(file);
					break;
				case 2:
					remove(file);
					break;
				case 3:
					readFile(file);
					break;
				case 4:
					cont = false;
					break;
			}
		}
		
		System.out.println("Goodbye!");
		userIn.close();

	}
	
	public static void write(String fileName) throws Exception {
		FileWriter fileOut = new FileWriter(fileName, true);
		Scanner userIn = new Scanner(System.in);
		
		String add;
		
		System.out.print("Enter What You Want to Add to the File\n? ");
		add = userIn.nextLine();
		
		fileOut.write(add+"\n");
		
		fileOut.close();
		readFile(fileName);
		userIn.close();
	}
	
	public static void remove(String fileName) throws Exception {
		Scanner input = new Scanner(System.in);
		File inFile = new File(fileName);
		File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
		BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
		PrintWriter tempFileOut = new PrintWriter(new FileWriter(tempFile));

		String line = null;
		int lineToRemove;
		int lineNum = 0;
		
		readFile(fileName);
		      
		while(true) {
		System.out.print("Enter line number to be deleted:\n? ");
		if(input.hasNextInt()) {
		    lineToRemove = input.nextInt();
		    break;
		}
		else
		    System.out.println("Invalid Input");
		}

		while ((line = fileIn.readLine()) != null) {
		    if (lineToRemove != lineNum) {
		        tempFileOut.println(line);
		        tempFileOut.flush();
		    }
		    lineNum++;
		}
		tempFileOut.close();
		fileIn.close();
		input.close();

		if (!inFile.delete()) {
		    System.out.println("Could not delete file");
		    return;
		}

		if (!tempFile.renameTo(inFile))
		    System.out.println("Could not rename file");

		readFile(fileName);
	}
	
	public static void readFile(String fileName) throws Exception {
		BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
		
		int i = 0;
		String temp = null;
		while((temp = fileIn.readLine()) != null) {
			System.out.println(i+" "+temp);
			i++;
		}
		System.out.println();
		fileIn.close();
	}
	
	
}
