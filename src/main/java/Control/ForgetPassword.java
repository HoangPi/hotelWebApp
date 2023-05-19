package Control;

import business.User;
import business.mailService;
import database.UserDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ForgetPassword", value = "/ForgetPassword")
public class ForgetPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //if this is forget========================================================================
        if(request.getParameter("action").equals("forget"))
        {
            if(request.getParameter("userName") == null || request.getParameter("email") ==null
                    || request.getParameter("userName").equals("")|| request.getParameter("email").equals(""))
            {
                request.setAttribute("forgetMessage","Please Unempty All The Fields");
                getServletContext()
                        .getRequestDispatcher("/forget-password.jsp")
                        .forward(request,response);
                return;
            }
            User user = UserDatabase.getUserByUsername(request.getParameter("userName"));
            //if user or email is invalid==========================================================
            if(user==null || !user.getEmail().equals(request.getParameter("email")))
            {
                request.setAttribute("forgetMessage","Incorrect Username or Email");
                getServletContext()
                        .getRequestDispatcher("/forget-password.jsp")
                        .forward(request,response);
            }
            //generate a code and put it in a time-limited session===============================
            else {
                HttpSession session = request.getSession();
                final Object lock = request.getSession().getId().intern();
                synchronized (lock)
                {
                    session.setAttribute("code",rng());
                    session.setAttribute("username",request.getParameter("userName"));
                    request.setAttribute("userName",request.getParameter("userName"));
                    session.setMaxInactiveInterval(300);
                }
                //send the code via email============================================================
                String dstEmail = user.getEmail();
                String sourceEmail = "mailofphifortesting@gmail.com";
                String subject = "Reset Password";
                String body = "Dear " + user.getFirstName() + " "+ user.getLastName() +
                        "\nThe code for resetting your password is: " + session.getAttribute("code");
                try
                {
                    mailService.sendEmail(dstEmail,subject,body);
                }
                catch (MessagingException ex)
                {
                    request.setAttribute("forgetMessage","Unable To Send Email");
                    getServletContext()
                            .getRequestDispatcher("/forget-password.jsp")
                            .forward(request,response);
                    return;
                }
                getServletContext()
                        .getRequestDispatcher("/forget-redirect.jsp")
                        .forward(request,response);
            }
        }
        //if this is a reset password================================================================
        else if(request.getParameter("action").equals("reset"))
        {
            //if something is null==================================================================
            if(request.getParameter("pass1") == null || request.getParameter("pass2") ==null
                    || request.getParameter("pass1").equals("")|| request.getParameter("pass2").equals("")
            || request.getParameter("code").equals("") || request.getParameter("code")==null)
            {
                request.setAttribute("forgetMessage","Please Unempty All The Fields");
                getServletContext()
                        .getRequestDispatcher("/ResetPassword.jsp")
                        .forward(request,response);
            }
            //if passwords does not match=============================================================
            else if(!request.getParameter("pass1").equals(request.getParameter("pass2")))
            {
                request.setAttribute("forgetMessage","Passwords Does Not Match");
                getServletContext()
                        .getRequestDispatcher("/ResetPassword.jsp")
                        .forward(request,response);
            }
            else {
                HttpSession session = request.getSession();
                //session time out========================================================================
                if(session.getAttribute("username")==null || session.getAttribute("code")==null)
                {
                    request.setAttribute("forgetMessage","Session Timeout, Please Be Faster Next Time");
                    getServletContext()
                            .getRequestDispatcher("/forget-password.jsp")
                            .forward(request,response);
                }
                //code does not meet the session===========================================================
                else if(!request.getParameter("code").equals(session.getAttribute("code"))){
                    request.setAttribute("forgetMessage","Incorrect PIN");
                    getServletContext()
                            .getRequestDispatcher("/ResetPassword.jsp")
                            .forward(request,response);
                }
                else {
                    //change password========================================================================
                    if(UserDatabase.changePassword((String)session.getAttribute("username"),request.getParameter("pass1")))
                    {
                        final Object lock = request.getSession().getId().intern();
                        User user = UserDatabase.getUserByUsername((String)session.getAttribute("username"));
                        synchronized (lock)
                        {
                            session.removeAttribute("code");
                            session.removeAttribute("username");
                            session.setAttribute("user",user);
                        }

                        getServletContext()
                                .getRequestDispatcher("/index.jsp")
                                .forward(request,response);
                    }
                    //Error while updating database==========================================================
                    else {
                        request.setAttribute("forgetMessage","Unexpected Error, Please Try Again");
                        getServletContext()
                                .getRequestDispatcher("/forget-password.jsp")
                                .forward(request,response);
                    }
                }
            }
        }
        else {
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request,response);
        }
    }
    private String rng()
    {
        int i;
        StringBuilder str = new StringBuilder("");
        java.util.Random rnd = new java.util.Random();
        for(int j=0;j<6;j++)
        {
            i = rnd.nextInt(10);
            str.append(i);
        }
        return String.valueOf(str);
    }
}
