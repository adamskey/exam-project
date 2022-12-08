package se.exam.project.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import se.exam.project.priority.Priority;
import se.exam.project.priority.PriorityRepository;
import se.exam.project.taskCategory.TaskCategory;
import se.exam.project.taskCategory.TaskCategoryRepository;
import se.exam.project.user.User;
import se.exam.project.user.UserRepository;

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

    @Autowired
    UserRepository userRepository;

    @Autowired
    PriorityRepository priorityRepository;

    @Autowired
    TaskCategoryRepository taskCategoryRepository;

    @GetMapping("/overview")
    public List<Tasks> overview() {
        return (List<Tasks>) taskRepository.findAll();
    }
    @PostMapping("/overview2")
    public List<DisplayTask> overview2(@RequestBody Integer id) {
        return taskJDBCRepository.getTasksByUserId(id);
    }

    @PostMapping("/overviewbyteam")
    public List<DisplayTask> overviewByTeam(@RequestBody Integer id) {
        return taskJDBCRepository.getTaskByTeamId(id);
    }

//    @GetMapping("/overviewById")
//    public List<Tasks> overviewById(Long id) {
//        return (List<Tasks>) taskRepository.findByAssignedTo(id);
//    }

    @PostMapping("/newtask")
    public Tasks newTask(@RequestBody NewTask task) {
        Tasks saveTask = new Tasks();

        if (task.getId().equals("")) {
            saveTask.setId(null);
        }

        List<TaskCategory> categories = taskCategoryRepository.findByCategoryType(task.getCategory());

        if (categories.size() > 0) {
            saveTask.setTaskCategory(categories.get(0));
            saveTask.getTaskCategory().setTeamTask(null);
            saveTask.getTaskCategory().setTaskList(null);
        }

        List<Priority> priorities = priorityRepository.findByPriorityName(task.getPriority());

        if (priorities.size() > 0) {
            saveTask.setPriorityId(priorities.get(0));
            saveTask.getPriorityId().setTaskList(null);
        }

        saveTask.setTitle(task.getTitle());

        saveTask.setDescription(task.getDescription());

        saveTask.setDue(Date.valueOf(task.getEnddate()));

        saveTask.setCreatedTimestamp(new Date(System.currentTimeMillis()));

        Optional<User> user = userRepository.findByUsername(task.getAssignto());

        user.ifPresent(saveTask::setAssignedTo);

        taskJDBCRepository.saveOrUpdate(saveTask);

        return saveTask;
    }

    @GetMapping("/detail/{id}")
    public DisplayTask viewTask(@PathVariable Integer id) {
        return taskJDBCRepository.getTaskById(id);
    }

    @PostMapping("/delete")
    public void deleteTask(@RequestBody Integer id) {
        taskJDBCRepository.deleteTask(id);
    }
}
