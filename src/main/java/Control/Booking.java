package Control;

import business.Room;
import database.RoomDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name = "Booking", value = "/Booking")
public class Booking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("room_option");
        List<Room> rooms = RoomDatabase.getAllAvailableRoomByType(parseInt(option));
        if(rooms == null || rooms.isEmpty())
        {
            //return user to the home page
            //but inform user that there are no available room for now
            request.setAttribute("booking_message","No room");
            getServletContext()
                    .getRequestDispatcher("Booking.jsp")
                    .forward(request,response);
        }
        else {
            request.setAttribute("rooms",rooms);
            getServletContext()
                    .getRequestDispatcher("Booking.jsp")
                    .forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
