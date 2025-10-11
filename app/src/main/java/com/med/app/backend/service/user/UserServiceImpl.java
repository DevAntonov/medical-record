package com.med.app.backend.service.user;

import com.med.app.backend.model.user.User;
import com.med.app.backend.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user)
    {
        return userRepository.save(user);
    }


    @Override
    public User getUserById(UUID userId)
    {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
    }


    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }


    @Override
    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
}
