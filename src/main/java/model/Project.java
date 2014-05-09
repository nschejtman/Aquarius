package model;


import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String FAQ;
    private boolean active;
    private Date start;
    private Date end;
    private Date lastUpdate;
    private int funds;
    private int objective;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @NotNull
    //@BatchSize(size = 10)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @NotNull
    private User user;

    private int favs;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<User> donnors;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<User> collaborators;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Collection<Tag> tags ;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Collection<Comment> comments;

    public Project(){}

    public Project(String name, String description, Date start, Date end, Type type,
                   User user) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.type = type;
        this.user = user;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}


    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}


    public String getFAQ() {return FAQ;}

    public void setFAQ(String FAQ) {this.FAQ = FAQ;}


    public boolean isActive() {return active;}

    public void setActive(boolean active) {this.active = active;}


    public Date getStart() {return start;}

    public void setStart(Date start) {this.start = start;}

    public Date getEnd() {return end;}

    public void setEnd(Date end) {this.end = end;}


    public Date getLastUpdate() {return lastUpdate;}

    public void setLastUpdate(Date lastUpdate) {this.lastUpdate = lastUpdate;}


    public int getFunds() {return funds;}

    public void setFunds(int funds) {this.funds = funds;}


    public int getObjective() {return objective;}

    public void setObjective(int objective) {this.objective = objective;}


    public Type getType() {return type;}

    public void setType(Type type) {this.type = type;}

    public void setTypeByName(String type){this.type = new Type(type);}


    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public void setUserByName(String name){this.user = new User(name);}


    public int getFavs() {return favs;}

    public void setFavs(int favs) {this.favs = favs;}


    public Collection<User> getDonnors() {return donnors;}

    public void setDonnors(Collection<User> donnors) {this.donnors = donnors;}


    public Collection<User> getCollaborators() {return collaborators;}

    public void setCollaborators(Collection<User> collaborators) {this.collaborators = collaborators;}


    public Collection<Tag> getTags() {return tags;}

    public void setTags(Collection<Tag> tags) {this.tags = tags;}

    public void addTags(Tag...tags){
        for (Tag tag : tags) {
            this.tags.add(tag);
            tag.addProject(this);
        }
    }


    public Collection<Comment> getComments() {return comments;}

    public void setComments(Collection<Comment> comments) {this.comments = comments;}
}