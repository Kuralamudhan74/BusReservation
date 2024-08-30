import java.sql.*;

public class BusDAO {
    public static void displayBusInfo() throws SQLException{
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        String query="select * from bus";
        ResultSet rs=st.executeQuery(query);

        while(rs.next())
        {
            System.out.println("Bus No: "+rs.getInt(1)+" --- AC: "+rs.getBoolean(2)+" --- Capacity: "+rs.getInt(3)+"");
        }
    con.close();
    }

    public int getCapacity(int id) throws SQLException{
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        String query="select capacity from bus where id="+id;
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }

}
