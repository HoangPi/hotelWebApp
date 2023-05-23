package business;

import database.RoomDatabase;
import database.UserDatabase;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public int getID() {
        return ID;
    }

    private String username;
    @Column(name = "room")
    private int roomNumber;
    private LocalDate datein;
    private LocalDate dateout;
    @Transient
    private Room bookedRoom;
    @Transient
    private RoomInfo roomInfo;
    @Transient
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Booking(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getDatein() {
        return datein;
    }

    public void setDatein(LocalDate datein) {
        this.datein = datein;
    }

    public LocalDate getDateout() {
        return dateout;
    }

    public void setDateout(LocalDate dateout) {
        this.dateout = dateout;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    public Booking(String username, int roomnumber, LocalDate in, LocalDate out)
    {
        setUsername(username);
        setRoomNumber(roomnumber);
        setDatein(in);
        setDateout(out);
        //Find user in database
        User temp = UserDatabase.getUserByUsername(username);
        setName(temp.getFirstName() + " "+ temp.getLastName());
        //Find Room and RoomInfo in database
        setBookedRoom(RoomDatabase.getRoomByNumber(roomnumber));
        setRoomInfo(RoomDatabase.getRoomInfoByType(this.getBookedRoom().getType()));
    }
    public void Innit(String username, int roomnumber, LocalDate in, LocalDate out)
    {
        setUsername(username);
        setRoomNumber(roomnumber);
        setDatein(in);
        setDateout(out);
        //Find user in database
        User temp = UserDatabase.getUserByUsername(username);
        setName(temp.getFirstName() + " "+ temp.getLastName());
        //Find Room and RoomInfo in database
        setBookedRoom(RoomDatabase.getRoomByNumber(roomnumber));
        setRoomInfo(RoomDatabase.getRoomInfoByType(this.getBookedRoom().getType()));
    }
    public float CalculateFee()
    {
        //If user have not stayed: return 0
        long used = this.getDatein().until(LocalDate.now(),ChronoUnit.DAYS);
        if(used<=0) return (float)0;
        //If user overstay, the price is every day*price
        long exceed = LocalDate.now().until(this.getDateout(),ChronoUnit.DAYS);
        if(exceed>=0) return (float)(Math.round((float)this.getRoomInfo().getPrice()*(used + 0.1*exceed)*100)) / 100;
        //If user leave early, the price is used*price and 10% of unused
        return (float)(Math.round((float)this.getRoomInfo().getPrice()*used*100)) / 100;
    }
}
