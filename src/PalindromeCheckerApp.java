import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();

        // Deque (Double Ended Queue)
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch); // Insert at rear
        }

        boolean isPalindrome = true;

        // Compare front and rear until empty or mismatch
        while (deque.size() > 1) {
            char front = deque.removeFirst(); // Remove from front
            char rear = deque.removeLast();   // Remove from rear

            if (front != rear) {
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