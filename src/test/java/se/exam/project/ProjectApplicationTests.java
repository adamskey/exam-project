package se.exam.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testDb() {
		Long count = userRepository.count();
		Assertions.assertEquals(5, count);
	}

}
