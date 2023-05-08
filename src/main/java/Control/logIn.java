package Control;

import business.User;
import database.UserDatabase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "logIn", value = "/logIn")
public class logIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            getServletContext()
                    .getRequestDispatcher("/log-in.jsp")
                    .forward(request,response);
        }
        else if(action.equals("logIn"))
        {
//            User user = new User("test@smail.com","test","test1","test","test");
            HttpSession session = request.getSession();
//            session.setAttribute("user",user);
            try {
                User user = UserDatabase.checkLogIn(request.getParameter("userName"),request.getParameter("password"));
                if(user!=null)
                {
                    final Object lock = request.getSession().getId().intern();
                    synchronized (lock){
                        session.removeAttribute("user");
                        session.setAttribute("user",user);
                        request.setAttribute("user",user);
                    }
                    getServletContext()
                            .getRequestDispatcher("/index.jsp")
                            .forward(request,response);
                }
                else {
                    request.setAttribute("message","User Name or Password Is Wrong");
                    getServletContext()
                            .getRequestDispatcher("/log-in.jsp")
                            .forward(request,response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
//            final Object lock = request.getSession().getId().intern();
//            synchronized (lock){
//                session.removeAttribute("user");
//                session.setAttribute("user",user);
//                request.setAttribute("user",user);
//            }
//            getServletContext()
//                    .getRequestDispatcher("/index.jsp")
//                    .forward(request,response);
        }
        else if(action.equals("forget"))
        {
            HttpSession session = request.getSession();
            final Object lock = request.getSession().getId().intern();
            synchronized (lock){
                session.removeAttribute("user");
                session.removeAttribute("forget");
                session.setAttribute("forget",forgetPassword((String)request.getAttribute("email")));
            }
            getServletContext()
                    .getRequestDispatcher("/forget-redirect.jsp")
                    .forward(request,response);
        }
    }
    // need edition
    private boolean checkLogIn(String username, String password)
    {
        return true;
    }
    private String forgetPassword(String mail)
    {
        String r = new String();
        r+='f';

        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));
        r+=Integer.toString(((int)Math.random()*10));

        return r;
    }
}
