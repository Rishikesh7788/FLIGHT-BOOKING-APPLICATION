package com.flightbookingSystem;

public class Booking {

    private Passenger passenger;
    private Flight flight;
    private String date;

    public Booking(Passenger passenger, Flight flight, String date) {
        this.passenger = passenger;
        this.flight = flight;
        this.date = date;
    }

    public void display() {
        System.out.println("Passenger: " + passenger.getName() + " | Contact: " + passenger.getContact());
        System.out.println("Flight: " + flight.getFlightNo() + " | Route: " 
                           + flight.getSource() + " -> " + flight.getDestination());
        System.out.println("Date: " + date + " | Price: Rs." + flight.getPrice());
        System.out.println("------------------------------------------");
    }

    
    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getDate() {
        return date;
    }
}
