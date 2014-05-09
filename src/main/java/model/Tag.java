package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany
    private Collection<Project> projects;

    public Tag(){}

    public Tag(String name) {
        this.name = name;
    }

    public void addProject(Project project){ projects.add(project);}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Project> getProjects() {return projects;}

    public void setProjects(Collection<Project> projects) {this.projects = projects;}
}
