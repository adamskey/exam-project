package se.exam.project.priority;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriorityRepository extends CrudRepository<Priority, Integer> {
    List<Priority> findByPriorityName(String priorityName);


}
