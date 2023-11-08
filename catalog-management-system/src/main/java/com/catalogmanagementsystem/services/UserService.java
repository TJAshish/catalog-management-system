package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.User;

public interface UserService {
    User register(User user);

	User getUserById(Long userId);
}
