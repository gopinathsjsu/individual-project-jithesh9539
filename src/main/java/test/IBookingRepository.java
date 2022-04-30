package test;

import java.util.ArrayList;

public interface IBookingRepository {
    void loadBookingDetails(String file);
    ArrayList<Booking> getAllBookings();
}
