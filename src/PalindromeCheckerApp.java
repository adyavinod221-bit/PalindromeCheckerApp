// File: UseCase6PalindromeCheckerApp.java

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class wee
        PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to check palindrome: ");
        String input = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Step 1: Enqueue and Push characters
        for (char ch : input.toCharArray()) {
            queue.add(ch);   // enqueue
            stack.push(ch);  // push
        }

        boolean isPalindrome = true;

        // Step 2: Compare dequeue vs pop
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.remove(); // dequeue
            char fromStack = stack.pop();    // pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Step 3: Result
        if (isPalindrome) {
            System.out.println("The word \"" + input + "\" IS a palindrome.");
        } else {
            System.out.println("The word \"" + input + "\" is NOT a palindrome.");
        }

        sc.close();
    }
}