package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BookingRepository implements IBookingRepository {

    ArrayList<Booking> bookings = new ArrayList<>();
    @Override
    public void loadBookingDetails(String file) {
        Path pathToFile = Paths.get(file);
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            br.readLine();
            String line = br.readLine();
            while(line != null) {
                String[] attributes = line.split(",");
                Booking booking = createBooking(attributes);
                bookings.add(booking);
                line = br.readLine();
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public ArrayList<Booking> getAllBookings() {
        return bookings;
    }

    private static Booking createBooking(String[] attributes) {
        String bookingName = attributes[0];
        String flightNumber = attributes[1];
        String seatCategory = attributes[2];
        int noOfSeats = Integer.parseInt(attributes[3]);
        String paymentCardNumber = attributes[4];
        return new Booking(bookingName,flightNumber,seatCategory,noOfSeats,paymentCardNumber);
    }
}
