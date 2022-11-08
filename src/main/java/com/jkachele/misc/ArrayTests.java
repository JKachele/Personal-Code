package com.jkachele.personal;
import java.util.*;

public class ArrayTests {

	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<>();
		
		test.add("1");
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("5");
		
		while(!test.isEmpty()) {
			System.out.println(test);
			ArrayList<String> temp = new ArrayList<>();
			int i = 0;
			for(int j = 0; j < i; j++) {
				temp.add(test.get(j));
			}
			for(int j = i + 1; j < test.size(); j++) {
				temp.add(test.get(j));
			}
			test = temp;
			i++;
		}

	}

}
