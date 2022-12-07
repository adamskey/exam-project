package se.exam.project.priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.exam.project.taskCategory.TaskCategory;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/priority")
public class PriorityController {

    @Autowired
    PriorityRepository prioRepository;

    @Autowired
    PriorityJDBCRepository priorityJDBCRepository;

    @GetMapping("/all")
    public List<Priority> getPriorityList(){
        return priorityJDBCRepository.findAll();
    }
    //test

}
