package model;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Tag implements Serializable {
    long id;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String name;
}
