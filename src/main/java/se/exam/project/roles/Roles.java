package se.exam.project.roles;

import javax.persistence.*;

import se.exam.project.user.User;

import java.util.List;

@Entity
@Table(name = "Roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "[Name]", length = 20)
    private ERole name;

    public Roles() {
    }

    public Roles(ERole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
