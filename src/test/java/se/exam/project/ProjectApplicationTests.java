package se.exam.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.exam.project.tasks.Tasks;
import se.exam.project.user.User;
import se.exam.project.user.UserRepository;
import se.exam.project.tasks.TaskRepository;

import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TaskRepository taskRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testUser() {
		Long count = userRepository.count();
		Assertions.assertEquals(5, count);
	}
	@Test
	void testTasks() {
		Long count = taskRepository.count();
		Assertions.assertEquals(1000, count);
	}

	@Test
	void testTasksByAssignedTo() {
		User user = new User();
		user.setId(3);
		List<Tasks> tasksList = taskRepository.findByAssignedTo(user);
		Assertions.assertEquals(498, tasksList.size());
	}

}
