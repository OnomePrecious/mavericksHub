package com.maverickstube.repositories.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maverickstube.maverickshub.dtos.requests.LogInRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void authenticateUserTest() throws Exception {
        LogInRequest request = new LogInRequest();
        request.setUsername("john@email.com");
        request.setPassword("password");
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth")
               .contentType(MediaType.APPLICATION_JSON)
               .content(mapper.writeValueAsBytes(request)))
               .andExpect(status().isOk())
                .andDo(print());
    }
}
