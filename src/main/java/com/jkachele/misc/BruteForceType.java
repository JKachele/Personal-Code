package com.jkachele.misc;

import java.util.Scanner;

public class BruteForceType{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter String to be typed: ");
        String s = input.nextLine();

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = 'a';
            do {
                System.out.println(out.toString() + c);
                c++;
                wait(50);
            } while (s.charAt(i) != c);
            out.append(s.charAt(i));
        }

        System.out.println(out);
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
