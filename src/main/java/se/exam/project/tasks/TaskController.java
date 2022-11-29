package se.exam.project.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/overview")
    public List<Tasks> overview() {
        return (List<Tasks>) taskRepository.findAll();
    }

    @GetMapping("/overviewById")
    public List<Tasks> overviewById(Long id) {
        return (List<Tasks>) taskRepository.findByAssignedTo(id);
    }
}
