package util;
import javafx.collections.ObservableList;
import org.example.demo.models.Bookings;
import org.example.demo.util.dbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingsDB {
    public static void insert(Bookings booking) {
        dbHelper.insertData("bookings", booking);

//        try {
//            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("insert into bookings set (BookingDate, BookingNo, TravelerCount, CustomerId, TripTypeId, PackageId) values (?, ?, ?, ?, ?, ?)");
//            dbHelper.prepareStatement(stmt, booking.getBookingDate(), booking.getBookingNo(), booking.getTravelerCount(), booking.getCustomerId(), booking.getTripTypeId(), booking.getPackageId());
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }

    public static void delete(Bookings booking) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("delete from bookings where bookingID = ?");
            stmt.setInt(1, booking.getBookingId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Bookings booking) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("update bookings set BookingDate=?, BookingNo=?, TravelerCount=?, CustomerId=?, TripTypeId=?, PackageId=? where BookingId=?");
            dbHelper.prepareStatement(stmt, booking.getBookingDate(), booking.getBookingNo(), booking.getTravelerCount(), booking.getCustomerId(), booking.getTripTypeId(), booking.getPackageId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Bookings> getBookings() {
        return dbHelper.getData("select * from bookings", BookingsDB::formatBookings);
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