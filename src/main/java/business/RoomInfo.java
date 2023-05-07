package business;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "room")
public class RoomInfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "description")
    private String description;
    //=============================================================================
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        name = name;
    }

    public void setPrice(float price) {
        price = price;
    }
    //======================================================================================
    public void setDescription(String description) {
        description = description;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    //=========================================================================
}
