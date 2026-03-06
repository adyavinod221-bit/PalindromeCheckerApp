import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();

        // Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Enqueue and Push characters
        for (char ch : input.toCharArray()) {
            queue.add(ch);   // Enqueue
            stack.push(ch);  // Push
        }

        boolean isPalindrome = true;

        // Compare dequeue vs pop
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.remove(); // Dequeue
            char fromStack = stack.pop();    // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Output result
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }

        sc.close();
    }
}