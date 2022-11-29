package se.exam.project.user;

import jakarta.persistence.*;
import se.exam.project.roles.Roles;
import se.exam.project.tasks.Tasks;
import se.exam.project.team.Team;

import java.util.List;

@Entity
@Table(name = "[User]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private Integer role;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "ReportsTo")
    private Integer reportsTo;

    @Column(name = "TeamId")
    private Integer teamId;

    @ManyToOne(targetEntity = Roles.class)
    private List roleList;
    @OneToMany(targetEntity = Tasks.class)
    private List taskList;
    @ManyToOne(targetEntity = Team.class)
    private List teamList;

    @ManyToOne(targetEntity = User.class)
    private List employeeList;

    @OneToMany(targetEntity =User.class)
    private List managerList;

    public User() {
    }

    public User(String username, String password, Integer role, String createdDate, String email, String phoneNumber, Integer reportsTo, Integer teamId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdDate = createdDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reportsTo = reportsTo;
        this.teamId = teamId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", createdDate='" + createdDate + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reportsTo=" + reportsTo +
                ", teamId=" + teamId +
                '}';
    }
}
