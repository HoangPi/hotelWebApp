package business;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String username;
    private int room;
    @Column(name = "datein")
    private LocalDate dateIn;
    @Column(name = "dateout")
    private LocalDate dateOut;

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public int getRoom() {
        return room;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }
    public Invoice(){}

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }
}
