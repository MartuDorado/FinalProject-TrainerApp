package com.finalproject.user;

import com.finalproject.user.model.User;
import com.finalproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDate;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
    @Autowired
	UserRepository userRepository;


	static String passwordEncoder(String rawPassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		return bCryptPasswordEncoder.encode(rawPassword);
	}

	public void run(String... args) throws Exception {

		User user = new User();
		user.setUserName("sebamarchin@gmail.com");
		user.setPassword(passwordEncoder("1234"));
		user.setName("Sebastián");
		user.setDateOfBirth(LocalDate.of(1993,12,22));
		user.setAge();
		userRepository.save(user);
	}
}
