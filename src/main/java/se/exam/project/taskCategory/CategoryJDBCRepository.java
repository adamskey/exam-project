package se.exam.project.taskCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import se.exam.project.tasks.DisplayTask;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryJDBCRepository {

    @Autowired
    private DataSource dataSource;

    public List<TaskCategory> findAll(){
        List<TaskCategory> taskCategories = new ArrayList<>();
//test
        try(Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM TaskCategory")) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                TaskCategory taskCategory = new TaskCategory();
                taskCategory.setId(resultSet.getInt("ID"));
                taskCategory.setCategoryType(resultSet.getString("CategoryType"));
                taskCategories.add(taskCategory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskCategories;
    }
}
