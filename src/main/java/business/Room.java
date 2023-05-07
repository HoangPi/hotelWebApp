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
    private int Available;

    public int getNumber() {
        return Number;
    }

    public int getType() {
        return Type;
    }

    public int getAvailable() {
        return Available;
    }
}
