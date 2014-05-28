package model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Date birthday;


    private long reputation;

    @NotNull
    private String userName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private boolean active;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Collection<Project> projects;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Project> favedProjects;

    @OneToMany
    private Collection<User> followedUsers;

    @OneToMany
    private Collection<User> allies;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Collection<Notification> notifications;

    @OneToMany
    private Collection<Message> messages;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String firstName, String lastName, Date birthday, String userName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public Collection<Project> getFavedProjects() {
        return favedProjects;
    }

    public void setFavedProjects(Collection<Project> favedProjects) {
        this.favedProjects = favedProjects;
    }

    public Collection<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(Collection<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public Collection<User> getAllies() {
        return allies;
    }

    public void setAllies(Collection<User> allies) {
        this.allies = allies;
    }

    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }

    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", reputation=" + reputation +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", projects=" + projects +
                ", favedProjects=" + favedProjects +
                ", followedUsers=" + followedUsers +
                ", allies=" + allies +
                ", notifications=" + notifications +
                ", messages=" + messages +
                '}';
    }

    //Nav display methods start-------------------------------------------
    //TODO descablear
    public int getUnreadNotificationsQty() {
        return 5;
    }

    public int getUnreadMessagesQty() {
        return 50;
    }

    public int getCommunityUpdatesQty() {
        return 10;
    }
    //Nav display methods end---------------------------------------------
}
