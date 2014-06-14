package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Project {

    //Constructor variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String description;
    String faq;
    long start;
    long end;
    int objective;
    String html;

    @ManyToOne
    Country country;

    @ManyToOne
    Type type;

    @ManyToOne
    User user;

    @ManyToMany
    Collection<Tag> tags;

    //Non-constructor variables
    @OneToMany(mappedBy = "project")
    Collection<Update> updates;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFaq() {
        return faq;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int getObjective() {
        return objective;
    }

    public String getHtml() {
        return html;
    }

    public Country getCountry() {
        return country;
    }

    public Type getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public Collection<Update> getUpdates() {
        return updates;
    }

    public Collection<User> getFollowers() {
        return followers;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public Collection<Fund> getFunds() {
        return funds;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PROJECT_FOLLOWERS", inverseJoinColumns = {@JoinColumn(name = "FOLLOWER_ID")})
    Collection<User> followers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "project")
    Collection<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    Collection<Image> images;

    @OneToMany(mappedBy = "project")
    Collection<Fund> funds;

    public Project() {
    }

    public Project(String name, String description, String faq, long start, long end, int objective, String html, Country country, Type type, User user, Collection<Tag> tags) {
        this.name = name;
        this.description = description;
        this.faq = faq;
        this.start = start;
        this.end = end;
        this.objective = objective;
        this.html = html;
        this.country = country;
        this.type = type;
        this.user = user;
        this.tags = tags;

        //Initialize
        updates = new ArrayList<Update>();
        followers = new ArrayList<User>();
        comments = new ArrayList<Comment>();
        images = new ArrayList<Image>();
        funds = new ArrayList<Fund>();

    }
}