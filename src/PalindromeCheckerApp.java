// File: UseCase13PalindromeCheckerApp.java

import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String getName(); // For reporting
}

// Stack-based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }

    @Override
    public String getName() {
        return "Stack Strategy";
    }
}

// Deque-based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Deque Strategy";
    }
}

// Simple Two-Pointer Strategy
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public String getName() {
        return "Two-Pointer Strategy";
    }
}

// Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC13: Performance Comparison) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // List of strategies to compare
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        System.out.println("\nPerformance Results:");
        for (PalindromeStrategy strategy : strategies) {
            long start = System.nanoTime();
            boolean result = strategy.isPalindrome(input);
            long end = System.nanoTime();
            long duration = end - start;

            System.out.printf("%-20s | Result: %-5s | Time: %d ns%n",
                    strategy.getName(),
                    result ? "Yes" : "No",
                    duration);
        }
    }
}