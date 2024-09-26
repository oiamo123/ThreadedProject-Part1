package org.example.demo.util;

import javafx.collections.ObservableList;
import org.example.demo.models.BookingDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDetailsDB {
    public static void insert(BookingDetails bk) {
            dbHelper.insertData(bk);
    }

    public static void delete(BookingDetails bk) {
        dbHelper.deleteData(bk);
    }

    public static void update(BookingDetails bk) {
        dbHelper.updateData(bk);
    }

    public static ObservableList<BookingDetails> getBookingDetails() {
        return dbHelper.getData("select * from bookingdetails", BookingDetailsDB::formatBookingDetails);
    }

    private static BookingDetails formatBookingDetails(ResultSet rs) {
        BookingDetails bk = new BookingDetails();
        try {
            bk.setBookingDetailId(rs.getInt(1));
            bk.setItineraryNo(rs.getInt(2));
            bk.setTripStart(rs.getDate(3));
            bk.setTripEnd(rs.getDate(4));
            bk.setDescription(rs.getString(5));
            bk.setDestination(rs.getString(6));
            bk.setBasePrice(rs.getDouble(7));
            bk.setAgencyCommission(rs.getDouble(8));
            bk.setBookingId(rs.getInt(9));
            bk.setRegionId(rs.getString(10));
            bk.setClassId(rs.getString(11));
            bk.setFeeId(rs.getString(12));
            bk.setProductSupplierId(rs.getInt(13));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bk;
    }
}