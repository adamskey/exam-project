package se.exam.project.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import se.exam.project.user.User;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/newtask")
    public void newTask(@RequestBody NewTask task) {
        Tasks saveTask = new Tasks();

        saveTask.setDue(Date.valueOf(task.getEnddate()));


       // saveTask.setTaskCategory();

        saveTask.setCreatedTimestamp(new Date(System.currentTimeMillis()));
        taskRepository.save(saveTask);
    }
    @PostMapping("/updatetask")
    public Tasks updateTask(@RequestBody Tasks task){
        task.setEdited(new Date(System.currentTimeMillis()));
        taskRepository.save(task);
        return taskRepository.findFirstByOrderByIdDesc();
    }

    @GetMapping("/detail/{id}")
    public DisplayTask viewTask(@PathVariable Integer id) {
        return taskJDBCRepository.getTaskById(id);
    }
}
