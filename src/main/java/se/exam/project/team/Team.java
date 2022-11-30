package se.exam.project.team;

import jakarta.persistence.*;
import se.exam.project.taskCategory.TaskCategory;
import se.exam.project.user.User;

import java.util.List;
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

    @ManyToMany
    Set <TaskCategory> teamTask;
    @OneToMany(targetEntity = User.class)
    private List userList;


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
