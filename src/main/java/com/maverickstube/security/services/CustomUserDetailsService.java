package com.maverickstube.security.services;

import com.maverickstube.exceptions.UserNotFoundException;
import com.maverickstube.models.User;
import com.maverickstube.security.models.SecureUser;
import com.maverickstube.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
           User user = userService.getUserByUsername(username);
            return new SecureUser(user);
        }catch (UserNotFoundException exception) {
            throw new UsernameNotFoundException(exception.getMessage());
        }

    }
}
