import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
    BusDAO.displayBusInfo();

    int UserOpt=1;
    Scanner scanner=new Scanner(System.in);

    while(UserOpt==1)
    {
        System.out.println("Enter 1 to Book or 2 to exit");
        UserOpt= scanner.nextInt();
        if(UserOpt==1)
        {
            Booking booking=new Booking();
            if(booking.isAvailable()){
                BookingDAO bookingdao=new BookingDAO();
                bookingdao.addBooking(booking);
                System.out.println("Your booking is confirmed");
            }
            else{
                System.out.println("Sorry Bus is full, try other bus");
            }
        }
    }


    }

}