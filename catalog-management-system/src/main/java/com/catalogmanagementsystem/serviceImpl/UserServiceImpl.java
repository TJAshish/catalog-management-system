package com.catalogmanagementsystem.serviceImpl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.catalogmanagementsystem.entities.User;
import com.catalogmanagementsystem.exceptions.UserNotFoundException;
import com.catalogmanagementsystem.exceptions.UserRegistrationException;
import com.catalogmanagementsystem.repository.UserRepository;
import com.catalogmanagementsystem.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new UserRegistrationException("User registration failed. Email already exists.");
        } catch (Exception ex) {
            throw new ServiceException("An error occurred during user registration.");
        }
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
    }
}
