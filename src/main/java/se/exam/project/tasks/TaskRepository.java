package se.exam.project.tasks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.exam.project.user.User;

import java.util.List;

public interface TaskRepository extends CrudRepository<Tasks, Integer> {

    List<Tasks> findByAssignedTo(User user);
}
