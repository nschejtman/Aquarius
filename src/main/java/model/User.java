package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private long reputation;
    private String userName;
    private String email;
    private String password;
    private boolean active;

//    @ManyToOne
//    private Project projects;
//
//    @ManyToOne
//    private Project favedProjects;
//
//    @ManyToOne
//    private User followedUsers;
//
//    @ManyToOne
//    private User allies;
//
//    @ManyToOne
//    private Notification notifications;
//
//    @ManyToOne
//    private Message messages;

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getReputation() {
        return reputation;
    }

    public void setReputation(long reputation) {
        this.reputation = reputation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public Project getProjects() {
//        return projects;
//    }
//
//    public void setProjects(Project projects) {
//        this.projects = projects;
//    }
//
//    public Project getFavedProjects() {
//        return favedProjects;
//    }
//
//    public void setFavedProjects(Project favedProjects) {
//        this.favedProjects = favedProjects;
//    }
//
//    public User getFollowedUsers() {
//        return followedUsers;
//    }
//
//    public void setFollowedUsers(User followedUsers) {
//        this.followedUsers = followedUsers;
//    }
//
//    public User getAllies() {
//        return allies;
//    }
//
//    public void setAllies(User allies) {
//        this.allies = allies;
//    }
//
//    public Notification getNotifications() {
//        return notifications;
//    }
//
//    public void setNotifications(Notification notifications) {
//        this.notifications = notifications;
//    }
//
//    public Message getMessages() {
//        return messages;
//    }
//
//    public void setMessages(Message messages) {
//        this.messages = messages;
//    }
}
