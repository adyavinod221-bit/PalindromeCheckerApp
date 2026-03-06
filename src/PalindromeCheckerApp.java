// File name: UseCase4RoomSearch.java

import java.util.ArrayList;
import java.util.List;

// Domain Model: Room
class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return "Room Type: " + type + ", Price: $" + price + ", Amenities: " + amenities;
    }
}

// Inventory as State Holder
class Inventory {
    private List<Room> rooms;
    private List<Integer> availability;

    public Inventory() {
        rooms = new ArrayList<>();
        availability = new ArrayList<>();
    }

    public void addRoom(Room room, int availableCount) {
        rooms.add(room);
        availability.add(availableCount);
    }

    // Read-only access: retrieve availability without modifying
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            if (availability.get(i) > 0) { // Validation Logic
                availableRooms.add(rooms.get(i));
            }
        }
        return availableRooms;
    }
}

// Search Service – Separation of Concerns
class SearchService {
    private Inventory inventory;

    public SearchService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms() {
        List<Room> availableRooms = inventory.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available at the moment.");
        } else {
            System.out.println("Available Rooms:");
            for (Room room : availableRooms) {
                System.out.println(room);
            }
        }
    }
}

// Actor: Guest
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // Setup inventory
        Inventory inventory = new Inventory();
        inventory.addRoom(new Room("Deluxe", 120.0, "WiFi, TV, AC"), 3);
        inventory.addRoom(new Room("Suite", 250.0, "WiFi, TV, AC, Mini Bar"), 0);
        inventory.addRoom(new Room("Standard", 80.0, "WiFi, Fan"), 5);

        // Guest initiates search
        SearchService searchService = new SearchService(inventory);
        searchService.displayAvailableRooms();
    }
}

