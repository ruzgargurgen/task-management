package com.tr.task.startup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tr.task.entity.Task;
import com.tr.task.entity.User;
import com.tr.task.repository.TaskRepository;
import com.tr.task.repository.UserRepository;

@Component
public class Startup implements CommandLineRunner {

	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private BCryptPasswordEncoder bycBCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Task>tasks=new ArrayList<>();
		
		for (int i=0;i<20;i++) {
			Task task=new Task();
			task.setName("görev-"+i);
			task.setDescription("görev aciklamasi"+i);
			tasks.add(task);
		}
		
		this.taskRepository.saveAll(tasks);
		
		createUsers();
		
	}
	
	
	void createUsers(){
		
		User user=new User();
		user.setUserName("ozaytunctan");
		user.setEmail("ozaytunctan@gmail.com");
		user.setFullName("Ozay TUNCTAN");
		user.setPassword(bycBCryptPasswordEncoder.encode("1234"));

		this.userRepository.save(user);
		
	}
}
