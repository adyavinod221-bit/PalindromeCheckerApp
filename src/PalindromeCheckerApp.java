// File name: UseCase5BookingRequestQueue.java

import java.util.LinkedList;
import java.util.Queue;

// Actor: Reservation
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Reservation Request -> Guest: " + guestName + ", Room Type: " + roomType;
    }
}

// Booking Request Queue
class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Accept booking requests
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Request added: " + reservation);
    }

    // Display queued requests (read-only, no allocation yet)
    public void displayRequests() {
        System.out.println("\nQueued Booking Requests (FIFO Order):");
        for (Reservation r : requestQueue) {
            System.out.println(r);
        }
    }
}

// Main class
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guest submits booking requests
        bookingQueue.addRequest(new Reservation("Alice", "Deluxe"));
        bookingQueue.addRequest(new Reservation("Bob", "Suite"));
        bookingQueue.addRequest(new Reservation("Charlie", "Standard"));

        // Display requests in arrival order
        bookingQueue.displayRequests();
    }
}