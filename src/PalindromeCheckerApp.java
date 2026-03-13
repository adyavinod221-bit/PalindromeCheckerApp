// File: UseCase11PalindromeCheckerApp.java

// PalindromeChecker class encapsulates the palindrome logic
class PalindromeChecker {
    // Method to check if a string is a palindrome
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Convert to lowercase for case-insensitive comparison
        input = input.toLowerCase();

        // Using internal data structure (stack-like approach with char array)
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Main application class
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        // Test cases
        String[] testInputs = {"madam", "racecar", "hello", "level", "Java"};

        for (String input : testInputs) {
            boolean result = checker.checkPalindrome(input);
            System.out.println("Is \"" + input + "\" a palindrome? " + result);
        }
    }
}