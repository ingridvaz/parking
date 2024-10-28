package com.api.rest.parking.service;

import com.api.rest.parking.entity.User;
import com.api.rest.parking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }
    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
    }

    @Transactional
    public User updatePassword(Long id, String actualPassword, String newPassword, String confirmPassword) {
        if(!newPassword.equals(confirmPassword)){
            throw new RuntimeException("Passwords is different");
        }

        User userUpdate = findById(id);
        if(!actualPassword.equals(userUpdate.getPassword())){
            throw new RuntimeException("Your password is wrong");
        }

        userUpdate.setPassword(newPassword);
        return userUpdate;
    }
}
