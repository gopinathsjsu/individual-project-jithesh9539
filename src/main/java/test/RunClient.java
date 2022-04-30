package test;
public class RunClient {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        BookingRepository bookingRepository = new BookingRepository();
        BookingProcessor bookingProcessor = new BookingProcessor(flightRepository,bookingRepository);
        bookingProcessor.intializeFlights(args[1]);
        bookingProcessor.initializeBookings(args[0]);
        bookingProcessor.doWork();
        bookingProcessor.printReport(args[2]);
        bookingProcessor.printErrors(args[3]);
    }
}

