package org.example.demo.services;
import javafx.collections.ObservableList;
import org.example.demo.models.Bookings;
import org.example.demo.util.dbHelper;

import java.sql.ResultSet;

public class BookingsService {
    public static void insert(Bookings booking) {
        dbHelper.insertData(booking);
    }

    public static void delete(Bookings booking) {
        dbHelper.deleteData(booking);
    }

    public static void update(Bookings booking) {
        dbHelper.updateData(booking);
    }

    public static ObservableList<Bookings> getBookings() {
        return dbHelper.getData("select * from bookings", BookingsService::formatBookings);
    }

    private static Bookings formatBookings (ResultSet rs) {
        Bookings booking = new Bookings();
        try {
            booking.setBookingId(rs.getInt(1));
            booking.setBookingDate(rs.getDate(2));
            booking.setBookingNo(rs.getString(3));
            booking.setTravelerCount(rs.getInt(4));
            booking.setCustomerId(rs.getInt(5));
            booking.setTripTypeId(rs.getString(6));
            booking.setPackageId(rs.getInt(7));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return booking;
    }
}