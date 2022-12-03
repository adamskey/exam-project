package se.exam.project.taskCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/taskcategory")
public class TaskCategoryController {

    @Autowired
    TaskCategoryRepository taskCategoryRepository;

    @GetMapping("/all")
    public List<TaskCategory> getTaskCategory() {
        return (List<TaskCategory>) taskCategoryRepository.findAll();
    }
}
