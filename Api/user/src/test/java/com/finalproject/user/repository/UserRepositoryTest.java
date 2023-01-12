package com.finalproject.user.repository;

import com.finalproject.user.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = new User("Test@test.com", "password","Test", LocalDate.of(2022,12,01));
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteById("Test@test.com");
    }


    @Test
    public void findAll_users_userList() {
        List<User> userList = userRepository.findAll();
        for (User user: userList) {
            System.out.println(user);
        }
        assertEquals(2, userList.size());
    }

    @Test
    public void findById_validId_correctUser() {
        Optional<User> user = userRepository.findById("Test@test.com");
        assertTrue(user.isPresent());
        System.out.println(user.get());
        assertEquals("Test", user.get().getName());
    }

    @Test
    public void findById_invalidId_userNotPresent() {
        Optional<User> user = userRepository.findById("invalid@mail.com");
        assertFalse(user.isPresent());
    }
}