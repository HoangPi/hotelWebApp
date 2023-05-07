package database;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.persistence.*;
//import javax.persistence.Persistence;

//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel");
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
