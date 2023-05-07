package business;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    private String email;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String userName;
    private String password;

//    private Long ID;
    //===================================================================================

    public String getPassword(){
        return password;
    }
    public String getUserName(){
        return userName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setFirstName(String fname){
        firstName = fname;
    }
    public void setLastName(String lname){
        lastName = lname;
    }
    public void setEmail(String mail)
    {
        email = mail;
    }
    public void setUserName(String username){
        userName = username;
    }
    public void setPassword(String pass)
    {
        password = pass;
    }
    //====================================================================================
    public User()
    {
        password="";
        userName="";
        firstName="";
        lastName="";
        email="";
    }
    public User(String mail, String fname, String lname, String username, String pass)
    {
        email = mail;
        firstName = fname;
        lastName = lname;
        userName = username;
        password = pass;
    }

//    public void setID(Long id) {
//        this.ID = id;
//    }
//
//    public Long getID() {
//        return ID;
//    }
}
