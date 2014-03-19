package model;

import java.util.Date;
import java.util.List;

public class Comment {
    String comment;
    User user;
    List<Comment> answers;
    Date date;
}
