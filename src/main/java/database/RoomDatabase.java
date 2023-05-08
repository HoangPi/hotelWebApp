package database;

import business.Room;
import business.RoomInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RoomDatabase {
    public static List<RoomInfo> getAllRoomInfo()
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM RoomInfo i";
        TypedQuery<RoomInfo> r = em.createQuery(query, RoomInfo.class);
        List<RoomInfo> listRoomInfos;
        try
        {
            listRoomInfos = r.getResultList();
            if(listRoomInfos == null || listRoomInfos.isEmpty()) listRoomInfos = null;
        }
        finally {
            em.close();
        }
        return listRoomInfos;
    }
    public static List<Room> getAllRoom()
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i";
        TypedQuery<Room> r = em.createQuery(query, Room.class);
        List<Room> Rooms;
        try{
            Rooms = r.getResultList();
            if(Rooms==null || Rooms.isEmpty()) Rooms = null;
        }
        finally {
            em.close();
        }
        return Rooms;
    }
    public static List<Room> getAllRoomByType(int type)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i WHERE i.Type = :type";
        TypedQuery<Room> r = em.createQuery(query,Room.class);
        List<Room> Rooms;
        try{
            Rooms = r.getResultList();
            if(Rooms==null || Rooms.isEmpty()) Rooms = null;
        }
        finally {
            em.close();
        }
        return Rooms;
    }
    public static List<Room> getAllAvailableRoomByType(int type)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i WHERE i.Type = :type AND i.Available = 1";
        TypedQuery<Room> r = em.createQuery(query,Room.class);
        List<Room> Rooms;
        try{
            Rooms = r.getResultList();
            if(Rooms==null || Rooms.isEmpty()) Rooms = null;
        }
        finally {
            em.close();
        }
        return Rooms;
    }
    public static List<Room> getAllAvailableRoom()
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i WHERE i.Available = 1";
        TypedQuery<Room> r = em.createQuery(query,Room.class);
        List<Room> Rooms;
        try{
            Rooms = r.getResultList();
            if(Rooms==null || Rooms.isEmpty()) Rooms = null;
        }
        finally {
            em.close();
        }
        return Rooms;
    }
    public static Room getRoomByNumber(int number)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        Room room;
        try{
            room = em.find(Room.class,number);
        }
        finally {
            em.close();
        }
        return room;
    }

}
