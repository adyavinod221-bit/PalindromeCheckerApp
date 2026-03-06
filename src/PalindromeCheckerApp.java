// File: UseCase10PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: if start >= end, it's a palindrome
        if (start >= end) {
            return true;
        }
        // If mismatch found, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive call: move inward
        return isPalindrome(str, start + 1, end - 1);
    }

    // Method to normalize string: remove spaces, ignore case
    public static String normalize(String input) {
        // Remove all spaces using regex and convert to lowercase
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";  // Example test case

        System.out.println("Original Input: " + input);

        // Normalize string before checking
        String normalized = normalize(input);

        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("Result: The string is a palindrome (ignoring case & spaces).");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}