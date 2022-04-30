package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingProcessor {
    private final IFlightRepository flightRepository;
    private final IBookingRepository bookingRepository;
    ArrayList<String> errors = new ArrayList<>();
    ArrayList<Report> reports = new ArrayList<>();

    BookingProcessor(IFlightRepository flightRepository,IBookingRepository bookingRepository) {
        this.flightRepository = flightRepository;
        this.bookingRepository = bookingRepository;
    }

    public void intializeFlights(String file) {
        this.flightRepository.loadFlightDetails(file);
    }

    public void initializeBookings(String file) {
        bookingRepository.loadBookingDetails(file);
    }

    public void doWork() {
        var flights = flightRepository.getAllFlights();
        var bookings = bookingRepository.getAllBookings();

        for(Booking booking:bookings) {
            var result = flightRepository.isFlightExist(booking.flightNumber,
                    booking.seatCategory);
            if(!result) {
                errors.add("Please enter correct booking details for "+booking.bookingName+": invalid flight number\n");
                continue;
            }
            var flight = flightRepository.getFlight(booking.flightNumber, booking.seatCategory);
            var totalPrice = flight.CalculateTotalPrice(booking.numberOfSeats);
            if(!isValidCard(booking.paymentCardNumber)) {
                errors.add("Please enter correct booking details for "+booking.bookingName+
                        ": Invalid Card\n");
                continue;
            }
            var isSuccess = flight.modifySeats(booking.numberOfSeats);
            if(!isSuccess) {
                errors.add("Please enter correct booking details for "+booking.bookingName+": no seats available in "
                        +booking.seatCategory+"\n");
                continue;
            }
            Report report = new Report(booking.bookingName,booking.flightNumber,booking.seatCategory,
                    booking.numberOfSeats,totalPrice);
            reports.add(report);

        }
    }

    public void printReport(String file) {
        var reportHeader = "BookingName,FlightNumber,SeatCategory,NoOfSeatsBooked,TotalPrice" + "\n";
        writeIntoFile(file, reports, reportHeader);

    }

    public  void printErrors(String file) {
        var errorHeader = "";
        writeIntoFile(file,errors,errorHeader);
    }
    public static Boolean isValidCard(String paymentCardNumber) {
        boolean isValid = false;
        String regex = "^(?:(4[0-9]{12}(?:[0-9]{3})?)|" +
                "([1-5]{1}[0-9]{15})|" +
                "(6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(3[47][0-9]{13}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(paymentCardNumber);
        if(matcher.matches()) isValid = true;
        return isValid;

    }

    private static <T> void writeIntoFile(String arg, ArrayList<T> records,String header) {
        FileWriter fw;
        try {
            fw = new FileWriter(arg);
            if(!header.isEmpty())
                fw.write(header);
            for (T record: records) {
                fw.write(record.toString());
            }
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
