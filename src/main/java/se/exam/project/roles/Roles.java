package se.exam.project.roles;

import jakarta.persistence.*;
import se.exam.project.user.User;

import java.util.List;

@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "[Name]")
    private String name;

    @OneToMany(targetEntity = User.class)
    private List userList;

    public Roles() {
    }

    public Roles(String name) {
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
