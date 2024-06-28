package com.maverickstube.services;

import com.maverickstube.maverickshub.dtos.requests.CreateUserRequest;
import com.maverickstube.maverickshub.dtos.responses.CreateUserResponse;
import com.maverickstube.maverickshub.exceptions.UserNotFoundException;
import com.maverickstube.maverickshub.models.User;

public interface UserService {
    CreateUserResponse register(CreateUserRequest request);

    User getById(Long id) throws UserNotFoundException;

    User getUserByUsername(String username) throws UserNotFoundException;
}

