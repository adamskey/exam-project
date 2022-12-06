package se.exam.project.tasks;

public class NewTask {
    private String category;
    private String priority;
    private String title;
    private String description;
    private String enddate;
    private String assignto;

    public NewTask() {
    }

    public NewTask(String category, String priority, String title, String description, String enddate, String assignto) {
        this.category = category;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.enddate = enddate;
        this.assignto = assignto;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getAssignto() {
        return assignto;
    }

    public void setAssignto(String assignto) {
        this.assignto = assignto;
    }

    @Override
    public String toString() {
        return "NewTask{" +
                "category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", enddate='" + enddate + '\'' +
                ", assignto='" + assignto + '\'' +
                '}';
    }
}
