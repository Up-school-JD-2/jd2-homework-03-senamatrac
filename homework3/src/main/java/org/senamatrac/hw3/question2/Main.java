package org.senamatrac.hw3.question2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter one word: ");
        StringBuilder reversedBuilder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        char[] letter = text.toCharArray();

        for (int i = letter.length-1; i > -1; i--) {
            reversedBuilder.append( letter[i] );
        }

        String reversed = reversedBuilder.toString();
        System.out.print("Backward word: " + reversed);
        if (text.equals(reversed)){
            System.out.print(" is a palindrome also");
        }

    }
}