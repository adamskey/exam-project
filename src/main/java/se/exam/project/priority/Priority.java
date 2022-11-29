package se.exam.project.priority;

import jakarta.persistence.*;

@Entity
@Table(name = "Priority")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PriorityName")
    private String priorityName;

    public Priority() {
    }

    public Priority(String priorityName) {
        this.priorityName = priorityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", priorityName='" + priorityName + '\'' +
                '}';
    }
}
