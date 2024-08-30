import java.sql.*;
import java.util.Date;

public class BookingDAO {

    public int getBookedCount(int busNo, Date date) throws SQLException {
        String Query="select count(passenger_name) from booking where bus_no=? and travel_date=?" ;
        Connection con=DBConnection.getConnection();
        PreparedStatement pst= con.prepareStatement(Query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1,busNo);
        pst.setDate(2,sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException{
        String query="insert into booking values(?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        pst.setString(1,booking.passenger_name);
        pst.setInt(2,booking.BusNo);
        pst.setDate(3,sqldate);
        pst.executeUpdate();

    }

}
