package se.exam.project.tasks;



import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TaskCategoryId")
    private Integer taskCategory;

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

    @Column(name="[assigned_to]")
    private Integer AssignedTo;

    @Column(name = "PriorityId")
    private Integer priorityId;

//    @ManyToOne(targetEntity= Priority.class)
//    private List priorityList;
//    @ManyToOne(targetEntity = User.class )
//    private List userList;
//    @ManyToOne(targetEntity = TaskCategory.class)
//    private List taskCategoryList;


    public Tasks() {
    }

    public Tasks(Integer taskCategory, Date createdTimestamp, Date due, Date edited, Date completed, String title, String description, Integer assignedTo, Integer priorityId) {
        this.taskCategory = taskCategory;
        this.createdTimestamp = createdTimestamp;
        this.due = due;
        this.edited = edited;
        this.completed = completed;
        this.title = title;
        this.description = description;
        this.AssignedTo = assignedTo;
        this.priorityId = priorityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(Integer taskCategory) {
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

    public Integer getAssignedTo() {
        return AssignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.AssignedTo = assignedTo;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
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
                ", assignedTo=" + AssignedTo +
                ", priorityId=" + priorityId +
                '}';
    }
}
