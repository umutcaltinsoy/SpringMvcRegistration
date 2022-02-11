package com.innova.service;

import com.innova.dto.UserValidationDto;
import com.innova.entity.UserEntity;

import java.util.List;
import java.util.Optional;

// UserServiceImpl implements this interface to use its methods
public interface UserService {

    // Save all the users in Database
    void saveUser(UserValidationDto userValidationDto);

    // Get all the users from database
    List<UserEntity> findAllUsers();

    // Find users by their Id
    Optional<UserEntity> findUserById(Long id);

    // Delete users by their Id
    void deleteUserById(Long id);

}
