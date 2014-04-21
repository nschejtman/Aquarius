package model;

import java.io.Serializable;
import java.lang.String;
import java.lang.System;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Entity;

import javax.persistence.*;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "PASSWORD")
    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(){}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public long getId() {
        return id;
    }

    public void setId(long id) {this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "main.java.model.User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

//    String lastName;
//    Date birthday;
//    long reputation;



//    Project projects;
//    List<Project> favedProjects;
//    List<User> followedUsers;
//    List<User> allies;
//    List<Notification> notifications;
//    List<Message> messages;
//    boolean active;

    /**
     * Sends a message to a specific user
     * @param recipient
     * @param message
     */
//    public void sendMessage(User recipient, String message){
//        Date now = new Date(System.currentTimeMillis());
//        Message msg = new Message(message, this, now);
//        recipient.receiveMessage(msg);
//    }

    /**
     * Recieves a message
     * @param message
     */
//    public void receiveMessage(Message message){
//        messages.add(message);
//    }




}
