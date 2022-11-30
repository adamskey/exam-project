package se.exam.project.taskCategory;

import jakarta.persistence.*;
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

    @ManyToMany(targetEntity = Team.class)
    private Set teamSet;
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
}
