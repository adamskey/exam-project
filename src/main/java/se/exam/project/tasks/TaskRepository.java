package se.exam.project.tasks;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Tasks, Integer> {
}
