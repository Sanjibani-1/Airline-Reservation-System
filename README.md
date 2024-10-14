# Airline-Reservation-System
#JAVA Project
#This Java program implements a simple Airline Reservation System. Here's a breakdown of the key components:

1. Flight Class
Attributes:

flightNumber: A unique identifier for each flight.
destination: The destination of the flight.
capacity: Maximum number of seats available on the flight.
bookedSeats: Tracks how many seats are currently booked.
Methods:

bookSeat(): Increases bookedSeats if there's availability and returns true if successful.
cancelSeat(): Decreases bookedSeats if there are seats booked and returns true if successful.
toString(): Returns a string representation of the flight details.
2. Passenger Class
Attributes:

name: The name of the passenger.
flightNumber: The flight number they are booked on.
Methods:

toString(): Returns a string representation of the passenger details.
3. AirlineReservationSystem Class (Main Class)
Attributes:

flights: A list of available flights.
passengers: A list of passengers who have booked flights.
scanner: Used to get input from the user.
Main Functionalities:

addFlight(): Allows users to add a new flight to the system.
bookFlight(): Books a seat for a passenger on a specific flight.
cancelFlight(): Cancels a passenger's flight booking and updates the flight's booked seats.
viewAllPassengers(): Displays a list of all passengers and their respective flights.
findFlight(): Finds a flight by its flight number.
findPassenger(): Finds a passenger based on name and flight number.
This system simulates basic airline reservation functionalities, including adding flights, booking, canceling flights, and managing passenger records.
