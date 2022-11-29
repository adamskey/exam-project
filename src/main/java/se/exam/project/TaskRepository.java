package se.exam.project;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Tasks, Integer> {
}
