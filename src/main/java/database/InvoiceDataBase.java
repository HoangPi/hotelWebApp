package database;

import business.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;

public class InvoiceDataBase {
    public static boolean checkValid(int roomNumber, LocalDate datein, LocalDate dateout)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Invoice i " +
                "WHERE i.dateIn < ?1 " +
                "and i.room = ?2 " +
                "and i.dateOut > ?3";
        TypedQuery<Invoice> r = em.createQuery(query,Invoice.class);
        r.setParameter(1,datein);
        r.setParameter(2, roomNumber);
        r.setParameter(3,dateout);
        ArrayList<Invoice> invoice = new ArrayList<Invoice>(r.getResultList());
        if(invoice==null || invoice.isEmpty()) return true;
        return false;
    }
}
