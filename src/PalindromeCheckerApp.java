// File: UseCase12PalindromeCheckerApp.java

import java.util.*;

// Step 1: Define the Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Step 2: Implement StackStrategy
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
}

// Step 3: Implement DequeStrategy
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
}

// Step 4: Context Class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(input);
    }
}

// Step 5: Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("=== Palindrome Checker App (UC12: Strategy Pattern) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: ");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1/2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            checker.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            checker.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        boolean result = checker.check(input);
        System.out.println("Result: \"" + input + "\" is " + (result ? "a palindrome." : "not a palindrome."));
    }
}