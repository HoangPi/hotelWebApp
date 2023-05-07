package database;

import business.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.*;

public class UserDatabase {
//    private static String dbURL = "jdbc:mysql://localhost:3306/hotel";
//    private static String dbUsername = "root";
//    private static String dbPassword = "Hoangphi09#";

    private static String dbURL = "jdbc:mysql://localhost:3306/hotel";
    private static String dbUsername = "root";
    private static String dbPassword = "Hoangphi09#";

    //Log In===================================================================================
    public static User checkLogIn(String username, String password) throws SQLException, ClassNotFoundException {
        User newuser = getUserByUsername(username);
        if(newuser==null) return newuser;
        if(newuser.getPassword().equals(password)) return newuser;
        return null;
    }
    //add new user (Sign Up)========================================================================
    public static boolean addUser(User user) throws SQLException, ClassNotFoundException {
        User newuser = getUserByUsername(user.getUserName());
        if(newuser==null)
        {
            EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();
            try {
                trans.begin();
                em.persist(user);
                trans.commit();

            }
            catch(Exception ex)
            {
                trans.rollback();
            }
            finally {
                em.close();
                return true;
            }
        }
        return false;
    }
    public static User getUserByUsername(String username)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        try
        {
            User user = em.find(User.class,username);
            return user;
        }
        finally {
            em.close();
        }
    }


}
