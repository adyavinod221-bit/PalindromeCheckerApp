// File: UseCase2PalindromeCheckerApp.java

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "madam";

        // Reverse the string
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}

