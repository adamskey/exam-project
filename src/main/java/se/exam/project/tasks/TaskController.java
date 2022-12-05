package se.exam.project.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.exam.project.user.User;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskJDBCRepository taskJDBCRepository;

    @GetMapping("/overview")
    public List<Tasks> overview() {
        return (List<Tasks>) taskRepository.findAll();
    }
    @GetMapping("/overview2")
    public List<DisplayTask> overview2() {
        int id = 1;
        return taskJDBCRepository.getTasksByUserId(id);
    }

    @GetMapping("/overviewbyteam")
    public List<DisplayTask> overviewByTeam() {
        int id = 1;
        return taskJDBCRepository.getTaskByTeamId(id);
    }

//    @GetMapping("/overviewById")
//    public List<Tasks> overviewById(Long id) {
//        return (List<Tasks>) taskRepository.findByAssignedTo(id);
//    }
}
