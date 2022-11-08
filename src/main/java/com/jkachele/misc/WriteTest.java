package com.jkachele.misc;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;

public class WriteTest {

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		
		try {

		      File inFile = new File("test.txt");
		      int lineToRemove = input.nextInt();
		      int lineNum = 0;


		      //Construct the new file that will later be renamed to the original filename.
		      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

		      BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		      String line = null;

		      //Read from the original file and write to the new
		      //unless content matches data to be removed.
		      while ((line = br.readLine()) != null) {

		        if (lineToRemove != lineNum) {

		          pw.println(line);
		          pw.flush();
		        }
		        lineNum++;
		      }
		      pw.close();
		      br.close();

		      //Delete the original file
		      if (!inFile.delete()) {
		        System.out.println("Could not delete file");
		        return;
		      }

		      //Rename the new file to the filename the original file had.
		      if (!tempFile.renameTo(inFile))
		        System.out.println("Could not rename file");

		    }
		    catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		    catch (IOException ex) {
		      ex.printStackTrace();
		    }
			input.close();
		}
		


	}


