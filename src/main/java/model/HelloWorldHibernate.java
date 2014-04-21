package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "HW")
public class HelloWorldHibernate implements Serializable {
    private long id;
    private String name;

    @Id
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    @Column(name = "HW_NAME", unique = false, nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
