package se.exam.project.taskCategory;

import jakarta.persistence.*;
import se.exam.project.team.Team;

import java.util.Set;

@Entity
@Table(name = "TaskCategory")
public class TaskCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "[Name]")
    private String name;

    @ManyToMany(targetEntity = Team.class)
    private Set teamSet;

    public TaskCategory() {
    }

    public TaskCategory(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
