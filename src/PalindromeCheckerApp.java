// File: UseCase5PalindromeCheckerApp.java

import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check if a string is palindrome using stack
    public static boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters and build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Compare original and reversed
        return input.equals(reversed.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it's a palindrome:");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: The string \"" + input + "\" IS a palindrome.");
        } else {
            System.out.println("Result: The string \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}