package database;

import business.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.*;

public class UserDatabase {

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
                return false;
            }
            finally {
                em.close();
                return true;
            }
        }
        return false;
    }
    public static boolean changePassword(String username, String newpassword)
    {
        User user = getUserByUsername(username);
        user.setPassword(newpassword);
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try
        {
            trans.begin();
            em.merge(user);
            trans.commit();
        }
        catch (Exception ex)
        {
            trans.rollback();
            return false;
        }
        finally {
            em.close();
            return true;
        }
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
