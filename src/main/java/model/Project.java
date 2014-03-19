package model;

import java.util.Date;
import java.util.List;

public class Project {
    String name;
    String description;
    String FAQ;
    boolean active;
    Date start;
    Date end;
    Date lastUpdate;
    int funds;
    int objective;
    User user;
    int favs;
    List<User> donnors;
    List<User> collaborators;
    List<Tag> tags;
    Type type;
    List<Comment> comments;
}
