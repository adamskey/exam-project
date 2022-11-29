package se.exam.project.team;

import jakarta.persistence.*;
import se.exam.project.taskCategory.TaskCategory;

import java.util.Set;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "[Name]")
    private String name;

    @ManyToMany(targetEntity = TaskCategory.class)
    private Set taskCategorySet;

    public Team() {
    }

    public Team(String name) {
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
