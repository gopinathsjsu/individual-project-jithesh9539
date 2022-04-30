package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FlightRepository implements IFlightRepository {
    ArrayList<Flight> flights = new ArrayList<>();
    Flight currentFlight;

    @Override
    public Flight getFlight(String flightNumber, String category) {
        for (Flight flight:flights) {
            if(flight.flightNumber.equals(flightNumber) && flight.category.equals(category)) {
                currentFlight = flight;
                return currentFlight;
            }
        }
        return currentFlight;
    }



    @Override
    public void loadFlightDetails(String file) {
        Path pathToFile = Paths.get(file);
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            br.readLine();
            String line = br.readLine();
            while(line != null) {
                String[] attributes = line.split(",");
                Flight flight = createFlight(attributes);
                flights.add(flight);
                line = br.readLine();
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public Boolean isFlightExist(String flightNumber,String seatCategory) {
        for (Flight flight:flights) {
            if(flight.flightNumber.equals(flightNumber) && flight.category.equals(seatCategory)) {
               return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Flight> getAllFlights() {
        return flights;
    }

    private static Flight createFlight(String[] attributes) {
        String category = attributes[0];
        String flightNumber = attributes[1];
        int noOfSeats = Integer.parseInt(attributes[2]);
        float priceOfSeat = Float.parseFloat(attributes[3]);
        String arrivalCity = attributes[4];
        String departureCity = attributes[5];

        return new Flight(category,flightNumber,noOfSeats,priceOfSeat,arrivalCity,departureCity);
    }

}
