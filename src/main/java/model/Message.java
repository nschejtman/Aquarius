package model;

import java.util.Date;

public class Message {
    String comment;
    boolean read;
    User source;
    Date date;

    public Message(String comment, User source, Date date) {
        this.comment = comment;
        read = false;
        this.source = source;
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public boolean isRead() {
        return read;
    }

    public User getSource() {
        return source;
    }

    public Date getDate() {
        return date;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
