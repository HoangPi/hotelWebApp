package database;

import business.Room;
import business.RoomInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomDatabase {
    public static ArrayList<RoomInfo> getAllRoomInfo()
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM RoomInfo i";
        TypedQuery<RoomInfo> r = em.createQuery(query, RoomInfo.class);
        ArrayList<RoomInfo> listRoomInfos;
        try
        {
            List<RoomInfo> temp = r.getResultList();
            listRoomInfos = new ArrayList<RoomInfo>(temp);
            if(listRoomInfos == null || listRoomInfos.isEmpty()) listRoomInfos = null;
        }
        finally {
            em.close();
        }
        return listRoomInfos;
    }
    public static ArrayList<Room> getAllRoom()
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i";
        TypedQuery<Room> r = em.createQuery(query, Room.class);
        ArrayList<Room> Rooms;
        try{
            Rooms = new ArrayList<Room>(r.getResultList());
            if(Rooms==null || Rooms.isEmpty()) Rooms = null;
        }
        finally {
            em.close();
        }
        return Rooms;
    }
    public static ArrayList<Room> getAllRoomByType(byte type)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i WHERE i.Type = :type";
        TypedQuery<Room> r = em.createQuery(query,Room.class);
        ArrayList<Room> Rooms;
        try{
            Rooms = new ArrayList<Room>(r.getResultList());
            if(Rooms==null || Rooms.isEmpty()) Rooms = null;
        }
        finally {
            em.close();
        }
        return Rooms;
    }
    public static ArrayList<Room> getAllAvailableRoomByType(byte type)
    {
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String query = "SELECT i FROM Room i WHERE i.Type = " + String.valueOf(type)+" AND i.Available = 1";
        TypedQuery<Room> r = em.createQuery(query,Room.class);
        ArrayList<Room> Rooms;
        try{
            Rooms = new ArrayList<Room>(r.getResultList());
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
