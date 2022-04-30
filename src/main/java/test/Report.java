package test;

public class Report {
    public String bookingName;
    public String flightNumber;
    public String categoryName;

    public int noOfSeatsBooked;
    public float totalPrice;


    public Report(String bookingName, String flightNumber, String categoryName, int noOfSeatsBooked, float totalPrice) {
        this.bookingName = bookingName;
        this.flightNumber = flightNumber;
        this.categoryName = categoryName;
        this.noOfSeatsBooked = noOfSeatsBooked;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return bookingName + ',' + flightNumber + ',' + categoryName + ',' + noOfSeatsBooked + ',' + totalPrice + "\n";
    }
}
