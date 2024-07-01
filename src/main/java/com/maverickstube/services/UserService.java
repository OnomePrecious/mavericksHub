package com.maverickstube.services;


import com.maverickstube.dtos.requests.CreateUserRequest;
import com.maverickstube.dtos.responses.CreateUserResponse;
import com.maverickstube.exceptions.UserNotFoundException;
import com.maverickstube.models.User;

public interface UserService {
    CreateUserResponse register(CreateUserRequest request);

    User getById(Long id) throws UserNotFoundException;

    User getUserByUsername(String username) throws UserNotFoundException;
}

