package com.jkachele.personal;
import java.util.Scanner;

public class LabProgram {
	
	public static String getPhoneNumber(String[] nameVec, String[] phoneNumberVec, String contactName) {
		
		String number = null;
		
		for(int i = 0; i < nameVec.length; i++) {
	    	  if(nameVec[i].compareTo(contactName) == 0)
	    		  number = phoneNumberVec[i];
	      }
		return number;
	}
	
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      String[] contact, number;
      String name;
      int numContacts;
      
      numContacts = input.nextInt();
      
      contact = new String[numContacts];
      number = new String[numContacts];
      
      for(int i = 0; i < contact.length; i++) {
    	  contact[i] = input.next();
    	  number[i] = input.next();
      }
      
      name = input.next();
      
      System.out.println(getPhoneNumber(contact, number, name));
      input.close();
   }
}
