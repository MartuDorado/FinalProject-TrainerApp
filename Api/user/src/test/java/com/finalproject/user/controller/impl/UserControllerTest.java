package com.finalproject.user.controller.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalproject.user.model.User;
import com.finalproject.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void createUser_validUser_userSaved() throws Exception{
        User user = new User("test@mail.com","Password","test", LocalDate.of(2021,5,30));
        String body = objectMapper.writeValueAsString(user);
        mockMvc.perform(post("/user/create-user").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

      //  assertTrue(mvcResult.getResponse().getContentAsString().contains("Test"));

        mockMvc.perform(delete("/user/create-user/test@mail.com"))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void getUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updatePassword() {
    }
}