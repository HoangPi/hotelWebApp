package database;

import Control.PurchaseHistoryControl;
import business.*;
import jakarta.faces.push.Push;
import jakarta.mail.FetchProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Byte.parseByte;

public class InvoiceDataBase {
    public static boolean checkValid(int roomNumber, LocalDate datein, LocalDate dateout)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Booking i " +
                "WHERE i.datein <= ?1 " +
                "and i.roomNumber = ?2 " +
                "and i.dateout >= ?3";
        TypedQuery<Booking> r = em.createQuery(query,Booking.class);
        r.setParameter(3,datein);
        r.setParameter(2, roomNumber);
        r.setParameter(1,dateout);
        ArrayList<Booking> bookings = new ArrayList<Booking>(r.getResultList());
//        if(bookings==null || bookings.isEmpty()) return true;
//        return false;
        return (bookings==null || bookings.isEmpty());
    }
    public static ArrayList<ItemLine> getInvoiceByUsername(String username)
    {
        ArrayList<ItemLine> il = new ArrayList<ItemLine>();
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Invoice i " +
                "WHERE i.username = ?1 ";
        TypedQuery<Invoice> r = em.createQuery(query,Invoice.class);
        r.setParameter(1,username);
        ArrayList<Invoice> invoice = new ArrayList<Invoice>(r.getResultList());
        if (invoice==null || invoice.isEmpty()) {
            return null;
        }
        for(int i =0;i<invoice.size();i++)
        {
            Room room = RoomDatabase.getRoomByNumber(invoice.get(i).getRoom());
            RoomInfo ri = RoomDatabase.getRoomInfoByType(room.getType());
            il.add(new ItemLine(invoice.get(i),ri.getPrice()));
        }
        return il;
    }
    public static boolean addInvoice(String username, int roomnumber, LocalDate datein, LocalDate dateout)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Invoice invoice = new Invoice();
        invoice.setDateIn(datein);
        invoice.setDateOut(dateout);
        invoice.setRoom(roomnumber);
        invoice.setUsername(username);
        try
        {
            trans.begin();
            em.persist(invoice);
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
    public static boolean removeInvoiceByID(int id)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "delete FROM Invoice i " +
                "WHERE i.ID = ?1 ";
        Query r = em.createQuery(query);
        r.setParameter(1,id);
        try
        {
            trans.begin();
            r.executeUpdate();
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
    //New====================================================================================
    public static boolean addBooking(Booking booking)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(booking);
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
    public static ArrayList<Booking> getAllBookingByUserName(String username)
    {
        ArrayList<Booking> booking = new ArrayList<Booking>();
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Booking i " +
                "WHERE i.username = ?1 ";
        TypedQuery<Booking> r = em.createQuery(query,Booking.class);
        r.setParameter(1,username);
        booking = new ArrayList<Booking>(r.getResultList());
        for(int i =0;i<booking.size();i++)
        {
            Booking b = booking.get(i);
            booking.get(i).Innit(b.getUsername(),b.getRoomNumber(),b.getDatein(),b.getDateout());
        }
        return booking;
    }
    public static boolean addToPurchaseHistory(Booking booking)
    {
        PurchaseHistory ph = new PurchaseHistory(booking);

        if(!removeBooking(booking.getID())) return false;
        //Price <= 0 only if the user have not used to service yet, therefore, no need to add
        if(ph.getPrice()>0)
        {
            EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();
            try {
                trans.begin();
                em.persist(ph);
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
        else return true;
    }
    public static boolean removeBooking(int id)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "delete FROM Booking i " +
                "WHERE i.ID = ?1 ";
        Query r = em.createQuery(query);
        r.setParameter(1,id);
        try
        {
            trans.begin();
            r.executeUpdate();
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
    public static ArrayList<PurchaseHistory> getPurchaseHistoryByUsername(String username)
    {
        ArrayList<PurchaseHistory> booking = new ArrayList<PurchaseHistory>();
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM PurchaseHistory i " +
                "WHERE i.username = ?1 ";
        TypedQuery<PurchaseHistory> r = em.createQuery(query,PurchaseHistory.class);
        r.setParameter(1,username);
        booking = new ArrayList<PurchaseHistory>(r.getResultList());
        for(int i=0;i<booking.size();i++)
        {
            booking.get(i).Init();
        }
        return booking;
    }
}
