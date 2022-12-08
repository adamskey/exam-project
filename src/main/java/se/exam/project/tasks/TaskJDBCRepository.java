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
                     "JOIN [User] AS u ON t.AssignedTo=u.ID\n" +
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

    public List<DisplayTask> getTaskByTeamId(Integer teamId) {
        List<DisplayTask> displayTaskList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT t.ID, tc.CategoryType, t.CreatedTimestamp, t.Due, t.Edited, t.Completed, t.Title, t.Description, p.PriorityName FROM Tasks AS t\n" +
                    "JOIN TaskCategory AS tc ON t.TaskCategoryId=tc.ID\n" +
                    "JOIN TaskCategoryTeam ON t.TaskCategoryId=TaskCategoryTeam.TaskCategoryId\n" +
                    "JOIN Team ON Team.ID=TaskCategoryTeam.TeamId\n" +
                    "JOIN [Priority] AS p ON t.PriorityId=p.ID\n" +
                    "WHERE Team.Id = ? AND t.AssignedTo IS NULL")) {
            statement.setInt(1, teamId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                displayTaskList.add(rsDisplayTaskNoUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return displayTaskList;
    }

    public DisplayTask getTaskById(Integer id) {
        DisplayTask displayTask = null;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT t.ID, tc.CategoryType, t.CreatedTimestamp, t.Due, t.Edited, t.Completed, t.Title, t.Description, u.Username, p.PriorityName FROM Tasks AS t\n" +
                                        "JOIN TaskCategory AS tc ON t.TaskCategoryId=tc.ID\n" +
                                        "JOIN TaskCategoryTeam ON t.TaskCategoryId=TaskCategoryTeam.TaskCategoryId\n" +
                                        "JOIN Team ON Team.ID=TaskCategoryTeam.TeamId\n" +
                                        "JOIN [User] AS u ON t.AssignedTo=u.ID\n" +
                                        "JOIN [Priority] AS p ON t.PriorityId=p.ID\n" +
                                        "WHERE t.ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                displayTask = rsDisplayTask(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return displayTask;
    }

    public void saveOrUpdate(Tasks task) {
        if (task.getId() == null) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement("INSERT INTO Tasks(TaskCategoryId, CreatedTimestamp, Due, Edited, Completed, Title, Description, AssignedTo, PriorityId)" +
                         "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                statement.setInt(1, task.getTaskCategory().getId());
                statement.setDate(2, task.getCreatedTimestamp());
                statement.setDate(3, task.getDue());
                statement.setDate(4, task.getEdited());
                statement.setDate(5, task.getCompleted());
                statement.setString(6, task.getTitle());
                statement.setString(7, task.getDescription());
                if (task.getAssignedTo() != null) {
                    statement.setInt(8, task.getAssignedTo().getId());
                } else {
                    statement.setNull(8, 4);
                }
                if (task.getPriorityId() != null) {
                    statement.setInt(9, task.getPriorityId().getId());
                } else {
                    statement.setNull(9, 4);
                }
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Tasks" +
                    "SET TaskCategoryId = ?, CreatedTimestamp = ?, Due = ?, Edited = ?, Completed = ?, Title = ?, Description = ?, AssignedTo = ?, PriorityId = ?" +
                    "WHERE ID = ?")) {
                statement.setInt(1, task.getTaskCategory().getId());
                statement.setDate(2, task.getCreatedTimestamp());
                statement.setDate(3, task.getDue());
                statement.setDate(4, task.getEdited());
                statement.setDate(5, task.getCompleted());
                statement.setString(6, task.getTitle());
                statement.setString(7, task.getDescription());
                statement.setInt(8, task.getAssignedTo().getId());
                statement.setInt(9, task.getPriorityId().getId());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteTask(Integer id) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Tasks WHERE ID = ?")) {
            statement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private DisplayTask rsDisplayTaskNoUser(ResultSet rs) throws SQLException {
        return new DisplayTask(rs.getInt("ID"),
                rs.getString("CategoryType"),
                rs.getDate("CreatedTimestamp"),
                rs.getDate("Due"),
                rs.getDate("Edited"),
                rs.getDate("Completed"),
                rs.getString("Title"),
                rs.getString("Description"),
                null,
                rs.getString("PriorityName"));
    }


}
