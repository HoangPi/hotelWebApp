package Control;

import business.Room;
import database.RoomDatabase;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Byte.parseByte;
import static java.lang.Integer.parseInt;

@WebServlet(name = "Booking", value = "/Booking")
public class Booking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("room_option");
        ArrayList<Room> rooms = RoomDatabase.getAllAvailableRoomByType(parseByte(option));
        if(rooms == null || rooms.isEmpty())
        {
            //return user to the home page
            //but inform user that there are no available room for now
            request.setAttribute("booking_message","No room");
            getServletContext()
                    .getRequestDispatcher("/Booking.jsp")
                    .forward(request,response);
        }
        else {
//            request.setAttribute("rooms",rooms);
            getServletContext()
                    .getRequestDispatcher("/Booking.jsp")
                    .forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
