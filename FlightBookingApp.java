package com.flightbookingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightBookingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Jacks");

        ArrayList<Passenger> passengers = new ArrayList<>();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

    
        flights.add(new Flight("AI101", "Chennai", "Delhi", 3500));
        flights.add(new Flight("EK505", "Mumbai", "Dubai", 8500));
        flights.add(new Flight("ING202", "Pune", "Kolkata", 4500));

        int passengerIdCounter = 1;

        while (true) {
            admin.showMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter contact: ");
                    String pcontact = sc.nextLine();

                    Passenger passenger = new Passenger(passengerIdCounter++, pname, pcontact);
                    passengers.add(passenger);

                    System.out.println("Passenger registered successfully!");
                    break;

                case 2:
                    System.out.println("\nAvailable Flights:");
                    for (Flight flight : flights) {
                        System.out.println(flight);
                    }
                    System.out.println();
                    break;

                case 3:
                   
                    if (passengers.isEmpty()) {
                        System.out.println("Register a Passenger");
                        break;
                    }
                    System.out.println("Passengers List:");
                    for (Passenger p : passengers) {
                        System.out.println(p.getId() + ": " + p.getName());
                    }
                    System.out.println("Enter Passenger ID:");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    Passenger selectedPssenger = null;
                    for (Passenger p : passengers) {
                        if (p.getId() == pid) {
                            selectedPssenger = p;
                            break;
                        }
                    }
                    if (selectedPssenger == null) {
                        System.out.println("Invalid ID");
                        break;
                    }

                 
                    System.out.println("Flights:");
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.println((i + 1) + ". " + flights.get(i).getFlightNo());
                    }
                    System.out.println("Choose Flight Number:");
                    int fid = sc.nextInt();
                    sc.nextLine();
                    if (fid < 1 || fid > flights.size()) {
                        System.out.println("Invalid Flight Number");
                        break;
                    }
                    Flight selectedFlight = flights.get(fid - 1);

                  
                    System.out.println("Enter Travel Date (dd-mm-yyyy):");
                    String date = sc.nextLine();

                  
                    bookings.add(new Booking(selectedPssenger, selectedFlight, date));
                    System.out.println("Flight Booked");
                    break;

                case 4:
                    System.out.println("\nAll Bookings:");
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings yet!");
                    } else {
                        for (Booking b : bookings) {
                            b.display();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter source: ");
                    String src = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String dst = sc.nextLine();

                    System.out.println("\nMatching Flights:");
                    boolean found = false;
                    for (Flight f : flights) {
                        if (f.getSource().equalsIgnoreCase(src) && f.getDestination().equalsIgnoreCase(dst)) {
                            System.out.println(f);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No matching flights found!");
                    break;

                case 6:
                    System.out.println("Thank you for using the Flight Booking System!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
