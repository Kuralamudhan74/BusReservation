import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Booking {
    String passenger_name;
    int BusNo;
    Date date;


    Booking(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the passenger name:");
        passenger_name=scanner.next();
        System.out.println("Enter the Bus Number:");
        BusNo=scanner.nextInt();
        System.out.println("Enter the date of journey in the format [dd-mm-yyyy]");
        String dateInput=scanner.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");

        try{
            date=dateFormat.parse(dateInput);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    public boolean isAvailable() throws SQLException {
        BusDAO busdao=new BusDAO();
        int capacity=busdao.getCapacity(BusNo);
        BookingDAO bookingdao=new BookingDAO();
        int booked=bookingdao.getBookedCount(BusNo, date);
        return booked < capacity;
    }


}
