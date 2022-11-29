package se.exam.project;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.exam.project.tasks.TaskRepository;
import se.exam.project.tasks.Tasks;

@RestController
public class ProjectController {

    @Autowired
    TaskRepository taskRepository;
    
    @GetMapping(name = "/home")
    public Iterable<Tasks> home() {
        return taskRepository.findAll();
    }
}
