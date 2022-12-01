package se.exam.project.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskJDBCRepository {

    @Autowired
    private DataSource dataSource;

    public List<DisplayTask> getTasksByUserId(Integer id) {
        List<DisplayTask> displayTaskList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT t.ID, tc.CategoryType, t.CreatedTimestamp, t.Due, t.Edited, t.Completed, t.Title, t.Description, u.Username, p.PriorityName FROM Tasks AS t\n" +
                     "JOIN TaskCategory AS tc ON t.TaskCategoryId=tc.ID\n" +
                     "JOIN TaskCategoryTeam ON t.TaskCategoryId=TaskCategoryTeam.TaskCategoryId\n" +
                     "JOIN Team ON Team.ID=TaskCategoryTeam.TeamId\n" +
                     "JOIN [User] AS u ON Team.ID=u.TeamId\n" +
                     "JOIN [Priority] AS p ON t.PriorityId=p.ID\n" +
                     "WHERE u.ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                displayTaskList.add(rsDisplayTask(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return displayTaskList;
    }

    private DisplayTask rsDisplayTask(ResultSet rs) throws SQLException {
        return new DisplayTask(rs.getInt("ID"),
                rs.getString("CategoryType"),
                rs.getDate("CreatedTimestamp"),
                rs.getDate("Due"),
                rs.getDate("Edited"),
                rs.getDate("Completed"),
                rs.getString("Title"),
                rs.getString("Description"),
                rs.getString("Username"),
                rs.getString("PriorityName"));
    }
}