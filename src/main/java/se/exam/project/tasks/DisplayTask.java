package se.exam.project.tasks;

import java.sql.Date;

public class DisplayTask {
    private Integer id;
    private String categoryType;
    private Date createdTimestamp;
    private Date due;
    private Date edited;
    private Date completed;
    private String title;
    private String description;
    private String username;
    private String priorityName;

    public DisplayTask() {
    }

    public DisplayTask(Integer id, String categoryType, Date createdTimestamp, Date due, Date edited, Date completed, String title, String description, String username, String priorityName) {
        this.id = id;
        this.categoryType = categoryType;
        this.createdTimestamp = createdTimestamp;
        this.due = due;
        this.edited = edited;
        this.completed = completed;
        this.title = title;
        this.description = description;
        this.username = username;
        this.priorityName = priorityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    @Override
    public String toString() {
        return "DisplayTask{" +
                "id=" + id +
                ", categoryType='" + categoryType + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", due=" + due +
                ", edited=" + edited +
                ", completed=" + completed +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", priorityName='" + priorityName + '\'' +
                '}';
    }
}
