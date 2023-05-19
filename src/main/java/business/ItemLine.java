package business;

import database.RoomDatabase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static java.lang.Byte.parseByte;
public class ItemLine implements Serializable {
    private Invoice invoice;
    private float price;
    private float cost;
    private String Name;
    private LocalDate checkOut;

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getName() {
        return Name;
    }

    //===================================================================================
    public Invoice getInvoice() {
        return invoice;
    }

    public float getPrice() {
        return price;
    }

    public float getCost() {
        return cost;
    }
    //====================================================================================
    public ItemLine(){}
    public ItemLine(Invoice invoice, float price)
    {
        this.invoice = invoice;
        this.price = price;
        Room r = RoomDatabase.getRoomByNumber(invoice.getRoom());
        RoomInfo ri = RoomDatabase.getRoomInfoByType(r.getType());
        this.Name = ri.getName();
        this.cost = this.calculateCost();
    }
    //====================================================================================
    public ItemLine(Invoice invoice, float price, LocalDate checkout)
    {
        this.checkOut = checkout;
        this.invoice = invoice;
        this.price = price;
        Room r = RoomDatabase.getRoomByNumber(invoice.getRoom());
        RoomInfo ri = RoomDatabase.getRoomInfoByType(r.getType());
        this.Name = ri.getName();
        this.cost = this.calculateCost();
    }
    private float calculateCost()
    {
        if(this.invoice==null) return 0;
        long used = this.invoice.getDateIn().until(LocalDate.now(), ChronoUnit.DAYS);
        long unused = LocalDate.now().until(this.invoice.getDateOut(),ChronoUnit.DAYS);
        if(used<=0) return 0;
        if(unused<=0) return (float) (used*1.0*price);
        return (float) (used*1.0*price+unused*0.2*price);
    }
}
