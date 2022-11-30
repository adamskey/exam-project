package se.exam.project.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.exam.project.user.User;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/overview")
    public List<Tasks> overview() {
        return (List<Tasks>) taskRepository.findAll();
    }
    @GetMapping("/overview2")
    public List<Tasks> overview2(@RequestParam Integer id) {
        User user = new User();
        user.setId(id);
        return taskRepository.findByAssignedTo(user);
    }

//    @GetMapping("/overviewById")
//    public List<Tasks> overviewById(Long id) {
//        return (List<Tasks>) taskRepository.findByAssignedTo(id);
//    }
}
