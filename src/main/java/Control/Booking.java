package Control;

import business.Room;
import business.RoomInfo;
import database.InvoiceDataBase;
import database.RoomDatabase;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Byte.parseByte;
import static java.lang.Integer.parseInt;

@WebServlet(name = "Booking", value = "/Booking")
public class Booking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("booking_message","No room");
//        getServletContext()
//                .getRequestDispatcher("/ListOfRoom.jsp")
//                .forward(request,response);
        //Check if the dates fields is null
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null)
        {
            request.setAttribute("bookingMessage","You Must Log In Before Using Our Service");
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request,response);
            return;
        }
        if(request.getParameter("Date_In")==null || request.getParameter("Date_In").equals("")
        || request.getParameter("Date_Out")==null || request.getParameter("Date_Out").equals(""))
        {
            request.setAttribute("bookingMessage","Please Unempty The Dates Fields");
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request,response);
            return;
        }
        //check if the dates are valid

        LocalDate in = null;
        LocalDate out = null;
        DateTimeFormatter format;

        try {
            String datebuffer = request.getParameter("Date_In");
            format = setFormatByString(datebuffer);
            in = LocalDate.parse(datebuffer, format);

            datebuffer = request.getParameter("Date_Out");
            format = setFormatByString(datebuffer);
            out = LocalDate.parse(datebuffer, format);
        } catch (Exception e) {
            request.setAttribute("bookingMessage","Unexpected Error, Please Try Again");
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request,response);
            return;
        }
        if(out.isBefore(in) || in.isBefore(LocalDate.now()))
        {
            request.setAttribute("bookingMessage","Invalid Dates");
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request,response);
            return;
        }
        //buffer the rooms (to be eliminated)
        String option = request.getParameter("room_option");
        ArrayList<Room> buffer = RoomDatabase.getAllAvailableRoomByType(parseByte(option));
        ArrayList<Room> rooms = new ArrayList<Room>();
        if(buffer == null || buffer.isEmpty())
        {
            //return user to the home page
            //but inform user that there are no available room for now
            request.setAttribute("booking_message","No room");
            getServletContext()
                    .getRequestDispatcher("/booking.jsp")
                    .forward(request,response);
            return;
        }
        for(int i =0;i<buffer.size();i++)
        {

            if(InvoiceDataBase.checkValid(buffer.get(i).getNumber(),in,out))
            {
                rooms.add(buffer.get(i));
            }
        }
        if(rooms == null || rooms.isEmpty())
        {
            //return user to the home page
            //but inform user that there are no available room for now
            request.setAttribute("booking_message","No room");
            getServletContext()
                    .getRequestDispatcher("/booking.jsp")
                    .forward(request,response);
        }
        else
        {
            RoomInfo inform = RoomDatabase.getRoomInfoByType(parseByte(option));
            request.setAttribute("rooms",rooms);
            request.setAttribute("price",String.valueOf(inform.getPrice()));
            getServletContext()
                    .getRequestDispatcher("/booking.jsp")
                    .forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/log-in.jsp")
                .forward(request,response);
    }
    public DateTimeFormatter setFormatByString(String date)
    {
        if(date.length()>=10)
        {
            return new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toFormatter() ;
        }
        else if(date.length()<=8)
        {
            return new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("M/d/yyyy")).toFormatter() ;
        }
        else
        {
            if(date.charAt(1)=='/')
            {
                return new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("M/dd/yyyy")).toFormatter() ;
            }
            else {
                return new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("MM/d/yyyy")).toFormatter() ;
            }
        }
    }
}
