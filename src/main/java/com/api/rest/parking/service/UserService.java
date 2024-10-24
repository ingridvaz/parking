package com.api.rest.parking.service;

import com.api.rest.parking.entity.User;
import com.api.rest.parking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public User updatePassword(Long id, String user) {
        User userUpdate = findById(id);
        userUpdate.setPassword(user);
        return userUpdate;
    }
}
