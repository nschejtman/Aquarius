package model;

import java.io.Serializable;
import java.lang.String;
import java.lang.System;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
    long id;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRSTNAME")
    String firstName;


    String lastName;
    Date birthday;
    long reputation;
    String userName;
    String email;
    String password;


//    Project projects;
//    List<Project> favedProjects;
//    List<User> followedUsers;
//    List<User> allies;
//    List<Notification> notifications;
//    List<Message> messages;
    boolean active;

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
