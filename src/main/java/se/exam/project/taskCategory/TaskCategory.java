package se.exam.project.taskCategory;

import javax.persistence.*;
import se.exam.project.tasks.Tasks;
import se.exam.project.team.Team;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TaskCategory")
public class TaskCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CategoryType")
    private String categoryType;

    @ManyToMany
    Set <Team> teamTask;

    @OneToMany(targetEntity = Tasks.class)
    private List TaskList;
    public TaskCategory() {
    }

    public TaskCategory(String categoryType) {
        this.categoryType = categoryType;
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

    public Set<Team> getTeamTask() {
        return teamTask;
    }

    public void setTeamTask(Set<Team> teamTask) {
        this.teamTask = teamTask;
    }

    public List getTaskList() {
        return TaskList;
    }

    public void setTaskList(List taskList) {
        TaskList = taskList;
    }
}
