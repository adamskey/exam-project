package se.exam.project.priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriorityJDBCRepository {

    @Autowired
    private DataSource dataSource;

    public List<Priority> findAll() {
        List<Priority> priorities = new ArrayList<>();
        //test
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Priority")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Priority priority = new Priority();
                priority.setId(resultSet.getInt("ID"));
                priority.setPriorityName(resultSet.getString("PriorityName"));
                priorities.add(priority);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priorities;
    }

}
