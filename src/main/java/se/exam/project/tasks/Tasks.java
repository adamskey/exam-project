package se.exam.project.tasks;



import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;
import se.exam.project.priority.Priority;
import se.exam.project.taskCategory.TaskCategory;
import se.exam.project.user.User;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @JoinColumn(name = "TaskCategoryId")
    @ManyToOne(targetEntity = TaskCategory.class)
    private TaskCategory taskCategory;

    @Column(name = "CreatedTimestamp")
    private Date createdTimestamp;

    @Column(name = "Due")
    private Date due;

    @Column(name = "Edited")
    private Date edited;

    @Column(name = "Completed")
    private Date completed;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @JoinColumn(name="AssignedTo")
    @ManyToOne(targetEntity = User.class)
    private User assignedTo;

    @JoinColumn(name = "PriorityId")
    @ManyToOne(targetEntity = Priority.class)
    private Priority priorityId;


    public Tasks() {
    }

    public Tasks(TaskCategory taskCategory, Date createdTimestamp, Date due, Date edited, Date completed, String title, String description, User assignedTo, Priority priorityId) {
        this.taskCategory = taskCategory;
        this.createdTimestamp = createdTimestamp;
        this.due = due;
        this.edited = edited;
        this.completed = completed;
        this.title = title;
        this.description = description;
        this.assignedTo = assignedTo;
        this.priorityId = priorityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Date getEdited() {
        return edited;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Priority getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Priority priorityId) {
        this.priorityId = priorityId;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", taskCategory=" + taskCategory +
                ", createdTimestamp=" + createdTimestamp +
                ", due=" + due +
                ", edited=" + edited +
                ", completed=" + completed +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo=" + assignedTo +
                ", priorityId=" + priorityId +
                '}';
    }
}
