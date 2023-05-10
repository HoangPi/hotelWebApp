package business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
@Entity
@Table(name = "roomlist")
public class Room implements Serializable{
    @Id
    @Column(name = "number")
    private int Number;
    @Column(name = "type")
    private int Type;
    @Column(name = "available")
    private byte Available;

    public int getNumber() {
        return Number;
    }

    public int getType() {
        return Type;
    }

    public byte getAvailable() {
        return Available;
    }
    public Room(int type, int number, byte available)
    {
        this.Type = type;
        this.Number = number;
        this.Available = available;
    }
    public Room(){}
}
