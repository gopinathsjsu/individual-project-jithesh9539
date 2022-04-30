package test;

import java.util.ArrayList;

public interface IFlightRepository {
    Flight getFlight(String flightNumber,String category);
    void loadFlightDetails(String arg);
    Boolean isFlightExist(String flightNumber, String seatCategory);
    ArrayList<Flight> getAllFlights();
}
