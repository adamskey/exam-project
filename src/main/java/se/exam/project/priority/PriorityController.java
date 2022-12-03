package se.exam.project.priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.exam.project.taskCategory.TaskCategory;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/priority")
public class PriorityController {

    @Autowired
    PriorityRepository prioRepository;

    @GetMapping("/all")
    public List<Priority> getPriorityList(){
        return (List<Priority>) prioRepository.findAll();
    }

}
