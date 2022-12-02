package se.exam.project.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import se.exam.project.roles.Roles;
import se.exam.project.tasks.Tasks;
import se.exam.project.team.Team;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "[User]",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "Username"),
        @UniqueConstraint(columnNames = "Email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank
    @Column(name = "Username")
    private String username;

    @NotBlank
    @Column(name = "Password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "UserRoles",
                joinColumns = @JoinColumn(name = "UserID"),
                inverseJoinColumns = @JoinColumn(name = "RoleID"))
    private Set<Roles> role = new HashSet<>();

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @JoinColumn(name = "ReportsTo")
    @ManyToOne(targetEntity = User.class)
    private User reportsTo;

    @JoinColumn(name = "TeamId")
    @ManyToOne(targetEntity = Team.class)
    private Team teamId;

    public User() {
    }

    public User(String username, String password, String createdDate, String email, String phoneNumber, User reportsTo, Team teamId) {
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reportsTo = reportsTo;
        this.teamId = teamId;
    }

    public User(String username, String password, Set<Roles> role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String createdDate, String email) {
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.email = email;
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

    public Set<Roles> getRole() {
        return role;
    }

    public void setRole(Set<Roles> role) {
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

    public User getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(User reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
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
