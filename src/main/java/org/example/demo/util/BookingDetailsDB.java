package util;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demo.models.BookingDetails;
import org.example.demo.util.dbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingDetailsDB {
    public static void insert(BookingDetails bk) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("insert into bookingdetails set (ItineraryNo, TripStart, TripEnd, Description, BasePrice, AgencyCommission, BookingId, RegionId, ClassId, FeeId, ProductSupplierId) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            dbHelper.prepareStatement(stmt, bk.getItineraryNo(), bk.getTripStart(), bk.getTripEnd(), bk.getDescription(), bk.getBasePrice(), bk.getAgencyCommission(), bk.getBookingId(), bk.getRegionId(), bk.getClassId(), bk.getFeeId(), bk.getProductSupplierId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(BookingDetails bk) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("delete from bookingdetails where BookingId = ?");
            stmt.setInt(1, bk.getBookingId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(BookingDetails bk) {
        try {
            PreparedStatement stmt = dbHelper.getConnection().prepareStatement("update bookingdetails set ItineraryNo, TripStart, TripEnd, Description, BasePrice, AgencyCommission, BookingId, RegionId, ClassId, FeeId, ProductSupplierId where BookingDetailId = ?");
            stmt.setInt(1, bk.getBookingId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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