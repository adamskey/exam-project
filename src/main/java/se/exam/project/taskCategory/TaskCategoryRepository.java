package se.exam.project.taskCategory;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskCategoryRepository extends CrudRepository<TaskCategory, Integer> {

    List<TaskCategory> findByCategoryType(String category);
}
