package database;

import business.*;
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
        String query = "SELECT i FROM Invoice i " +
                "WHERE i.dateIn <= ?1 " +
                "and i.room = ?2 " +
                "and i.dateOut >= ?3";
        TypedQuery<Invoice> r = em.createQuery(query,Invoice.class);
        r.setParameter(3,datein);
        r.setParameter(2, roomNumber);
        r.setParameter(1,dateout);
        ArrayList<Invoice> invoice = new ArrayList<Invoice>(r.getResultList());
        if(invoice==null || invoice.isEmpty()) return true;
        return false;
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
    public static boolean setInvoiceStatusToPaid(int id)
    {
        return true;
//        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        Invoice invoice = InvoiceDataBase.getInvoiceByID(id);
//        if(invoice == null) return false;
//        if(LocalDate.now().isBefore(invoice.getDateIn())) return removeInvoiceByID(id);
//
////        invoice.setDateOut(LocalDate.now());
//        invoice.setStatus((byte)0);
//        try
//        {
//            trans.begin();
//            em.merge(invoice);
//            trans.commit();
//        }
//        catch (Exception ex)
//        {
//            trans.rollback();
//            return false;
//        }
//        finally {
//            em.close();
//            return true;
//        }
    }
    public static Invoice getInvoiceByID(int id)
    {
        Invoice invoice = new Invoice();
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        try
        {
            invoice = em.find(Invoice.class,id);
        }
        finally {
            em.close();
            return invoice;
        }
    }
    public static boolean addToPurchaseHistory(int id)
    {
        return true;
    }
}
