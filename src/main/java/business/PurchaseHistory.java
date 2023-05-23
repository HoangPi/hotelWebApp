package business;

import database.RoomDatabase;
import jakarta.ejb.Init;
import jakarta.ejb.Local;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "purchasehistory")
public class PurchaseHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private int room;
    private String username;
    private LocalDate datein;
    private LocalDate dateout;
    private LocalDate checkout;
    private float price;

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    @Transient
    private RoomInfo roomInfo;

    public int getID() {
        return ID;
    }

    public int getRoom() {
        return room;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDatein() {
        return datein;
    }

    public LocalDate getDateout() {
        return dateout;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public float getPrice() {
        return price;
    }
    public PurchaseHistory(){}
    public PurchaseHistory(Booking booking)
    {
        this.room = booking.getRoomNumber();
        this.username = booking.getUsername();
        this.datein = booking.getDatein();
        this.dateout = booking.getDateout();
        this.checkout = LocalDate.now();
        this.price = booking.CalculateFee();
    }
    public void Init()
    {
        Room r = RoomDatabase.getRoomByNumber(this.room);
        this.roomInfo = RoomDatabase.getRoomInfoByType(r.getType());
    }
}
