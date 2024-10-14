import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Flight
class Flight {
    private final String flightNumber;
    private final String destination;
    private final int capacity;
    private int bookedSeats;

    public Flight(String flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public boolean bookSeat() {
        if (bookedSeats < capacity) {
            bookedSeats++;
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelSeat() {
        if (bookedSeats > 0) {
            bookedSeats--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Destination: " + destination +
                ", Capacity: " + capacity + ", Booked Seats: " + bookedSeats;
    }
}

// Class to represent a Passenger
class Passenger {
    private final String name;
    private final String flightNumber;

    public Passenger(String name, String flightNumber) {
        this.name = name;
        this.flightNumber = flightNumber;
    }

    public String getName() {
        return name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "Passenger Name: " + name + ", Flight Number: " + flightNumber;
    }
}

// Main Airline Reservation System class
public class AirlineReservationSystem {
    private static final ArrayList<Flight> flights = new ArrayList<>();
    private static final ArrayList<Passenger> passengers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeFlights();
        int choice;

        do {
            System.out.println("\nAirline Reservation System");
            System.out.println("1. View Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Cancel a Flight");
            System.out.println("4. View All Passengers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewAvailableFlights();
                case 2 -> bookFlight();
                case 3 -> cancelFlight();
                case 4 -> viewAllPassengers();
                case 5 -> System.out.println("Exiting the system. Thank you!");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    // Initialize some flights for the system
    private static void initializeFlights() {
        flights.add(new Flight("A123", "New York", 100));
        flights.add(new Flight("B456", "Los Angeles", 120));
        flights.add(new Flight("C789", "Chicago", 80));
    }

    // View available flights
    private static void viewAvailableFlights() {
        System.out.println("\nAvailable Flights:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    // Book a flight
    private static void bookFlight() {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter flight number to book: ");
        String flightNumber = scanner.nextLine();

        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            if (flight.bookSeat()) {
                passengers.add(new Passenger(name, flightNumber));
                System.out.println("Flight booked successfully!");
            } else {
                System.out.println("Sorry, no seats available on this flight.");
            }
        } else {
            System.out.println("Flight not found.");
        }
    }

    // Cancel a flight
    private static void cancelFlight() {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter flight number to cancel: ");
        String flightNumber = scanner.nextLine();

        Passenger passenger = findPassenger(name, flightNumber);
        if (passenger != null) {
            Flight flight = findFlight(flightNumber);
            if (flight != null && flight.cancelSeat()) {
                passengers.remove(passenger);
                System.out.println("Flight cancelled successfully!");
            } else {
                System.out.println("Failed to cancel the flight.");
            }
        } else {
            System.out.println("Passenger not found.");
        }
    }

    // View all passengers
    private static void viewAllPassengers() {
        System.out.println("\nList of all passengers:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    // Find a flight by its flight number
    private static Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    // Find a passenger by name and flight number
    private static Passenger findPassenger(String name, String flightNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name) &&
                passenger.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return passenger;
            }
        }
        return null;
    }

    public static ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
