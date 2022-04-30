package test;

import java.util.ArrayList;

public class Flight {
    private int noOfSeatsBooked ;
    public String category;
    public String flightNumber;
    public int noOfSeats;
    public float priceOfSeat;
    public String arrivalCity;
    public String departureCity;

    public int getNoOfSeatsBooked() {
        return noOfSeatsBooked;
    }
    public Flight() {

    }

    public Flight(String category, String fightNumber, int noOfSeats, float priceOfSeat, String arrivalCity, String departureCity) {
        this.category = category;
        this.flightNumber = fightNumber;
        this.noOfSeats = noOfSeats;
        this.priceOfSeat = priceOfSeat;
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
    }

    public float CalculateTotalPrice(int noOfSeatsInBooking) {
        return noOfSeatsInBooking * priceOfSeat;
    }

    public Boolean modifySeats(int noOfSeatsInBooking) {
        if(noOfSeatsInBooking > noOfSeats) return false;
        noOfSeatsBooked += noOfSeatsInBooking;
        this.noOfSeats = this.noOfSeats - noOfSeatsInBooking;
        return true;
    }
    

}
