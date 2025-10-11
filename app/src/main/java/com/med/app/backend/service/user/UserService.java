package com.med.app.backend.service.user;

import com.med.app.backend.model.user.User;

import java.util.List;
import java.util.UUID;

public interface UserService
{
    User createUser(User user);
    User getUserById(UUID userId);
    List<User> getAllUsers();
    User getUserByUsername(String username);
}
