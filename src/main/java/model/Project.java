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
        //Initialize
        updates = new ArrayList<Update>();
        followers = new ArrayList<User>();
        comments = new ArrayList<Comment>();
        images = new ArrayList<Image>();
        funds = new ArrayList<Fund>();
        tags = new ArrayList<Tag>();
    }

    public Project(String name, String description, String faq, long start, long end, int objective, String html, Country country, Type type, User user) {
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


        //Initialize
        updates = new ArrayList<Update>();
        followers = new ArrayList<User>();
        comments = new ArrayList<Comment>();
        images = new ArrayList<Image>();
        funds = new ArrayList<Fund>();
        tags = new ArrayList<Tag>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public void setObjective(int objective) {
        this.objective = objective;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addTag(Tag tag){tags.add(tag);}

    public void deleteAllTags() {
        tags.clear();
    }

}