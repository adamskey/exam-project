package se.exam.project.tasks;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Tasks, Integer> {

    List<Tasks> findByUserId(Long id);
}
