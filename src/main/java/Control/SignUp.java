package Control;

import business.User;
import database.UserDatabase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//import java.sql.Connection;
import java.sql.*;

@WebServlet(name = "SignUp", value = "/SignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request,response);
        }
        else if(action.equals("signUp"))
        {
            // check if fill all===============================================================
            if(request.getParameter("fname")==""
            || request.getParameter("lname")==""
            || request.getParameter("email")==""
            || request.getParameter("userName")==""
            || request.getParameter("password")==""
            || request.getParameter("reTypePassword")=="")
            {
                User user = new User(request.getParameter("email"),
                        request.getParameter("fname"),
                        request.getParameter("lname"),
                        request.getParameter("userName"),
                        request.getParameter("password"));
                request.setAttribute("user",user);
                request.setAttribute("message","Please fill all the fields");
                getServletContext()
                        .getRequestDispatcher("/sign-up.jsp")
                        .forward(request,response);
            }
            else {
                // check user's info================================================================
                String message = checkMatchPassword(request.getParameter("email"),
                        request.getParameter("userName"),
                        request.getParameter("password"),
                        request.getParameter("reTypePassword"));
                User user = new User(request.getParameter("email"),
                        request.getParameter("fname"),
                        request.getParameter("lname"),
                        request.getParameter("userName"),
                        request.getParameter("password"));
                if(message.equals("true"))
                {
                    //add user================================================================
                    try {
                        if(UserDatabase.addUser(user))
                        {
                            HttpSession session =request.getSession();
                            session.setAttribute("user",user);

    //                    request.setAttribute("user",user);
                            request.setAttribute("message",message);
                            getServletContext()
                                    .getRequestDispatcher("/index.jsp")
                                    .forward(request,response);
                        }
                        else {
                            request.setAttribute("user",user);
                            request.setAttribute("message","username exist");
                            getServletContext()
                                    .getRequestDispatcher("/sign-up.jsp")
                                    .forward(request,response);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(message.equals("passwords must be the same"))
                {
                    request.setAttribute("user",user);
                    request.setAttribute("message",message);
                    getServletContext()
                            .getRequestDispatcher("/sign-up.jsp")
                            .forward(request,response);
                }
            }
        }
    }
    private String checkMatchPassword(String email,String username, String password1, String password2)
    {
        //Later this will check the email and username from the database
        if(password1.equals(password2)) return "true";
        return "passwords must be the same";
    }

}
