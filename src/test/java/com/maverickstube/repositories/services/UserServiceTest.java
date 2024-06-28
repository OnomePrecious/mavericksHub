package com.maverickstube.repositories.services;


import com.maverickstube.maverickshub.dtos.requests.CreateUserRequest;
import com.maverickstube.maverickshub.dtos.responses.CreateUserResponse;
import com.maverickstube.maverickshub.exceptions.UserNotFoundException;
import com.maverickstube.maverickshub.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void registerTest(){
        CreateUserRequest request = new CreateUserRequest();
        request.setEmail("test@email.com");
        request.setPassword("password");

        CreateUserResponse response = userService.register(request);

        assertNotNull(response);
        assertTrue(response.getMessage().contains("success"));
    }

    @Test
    @DisplayName("test that user can be retrieved by id")
    @Sql(scripts = {"/db/data.sql"})
    public void testGetUserById() throws UserNotFoundException {
        User user = userService.getById(200L);
        assertThat(user).isNotNull();
    }


}
