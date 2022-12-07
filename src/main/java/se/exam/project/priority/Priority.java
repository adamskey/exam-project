package se.exam.project.priority;

import javax.persistence.*;
import se.exam.project.tasks.Tasks;

import java.util.List;

@Entity
@Table(name = "Priority")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PriorityName")
    private String priorityName;

    @OneToMany(targetEntity = Tasks.class)
    private List taskList;

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

    public List getTaskList() {
        return taskList;
    }

    public void setTaskList(List taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", priorityName='" + priorityName + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
