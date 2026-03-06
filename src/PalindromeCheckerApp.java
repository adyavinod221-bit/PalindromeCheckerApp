// File: UseCase2PalindromeCheckerApp.java

public class PalindromeCheckerApp {


    public static void main(String[] args) {

        // Original string literal
        String word = "madam";

        // Reverse string using loop
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            // String concatenation (+) builds a new String each time
            reversedWord += word.charAt(i);
        }

        // Compare original and reversed using equals()
        if (word.equals(reversedWord)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}


