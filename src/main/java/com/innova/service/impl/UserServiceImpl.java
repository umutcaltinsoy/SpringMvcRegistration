package com.innova.service.impl;

import com.innova.dto.UserValidationDto;
import com.innova.entity.UserEntity;
import com.innova.repository.UserRepository;
import com.innova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This annotation specifies it is a Service class
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserValidationDto userValidationDto) {
        UserEntity entity = new UserEntity();
        entity.setUserName(userValidationDto.getUserName());
        entity.setEmailAddress(userValidationDto.getEmailAddress());
        entity.setUserSurname(userValidationDto.getUserSurname());

        userRepository.save(entity);
    }


    public List<UserEntity> findAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        return optionalUserEntity;

    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }


}
