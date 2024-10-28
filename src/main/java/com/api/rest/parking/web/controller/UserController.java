package com.api.rest.parking.web.controller;

import com.api.rest.parking.entity.User;
import com.api.rest.parking.service.UserService;
import com.api.rest.parking.web.dto.RequestUserDTO;
import com.api.rest.parking.web.dto.UserPasswordDTO;
import com.api.rest.parking.web.dto.mapper.ResponseUserDTO;
import com.api.rest.parking.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseUserDTO> create(@RequestBody RequestUserDTO userCreateDTO){
        User users = userService.save(UserMapper.toUser(userCreateDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserDto(users));
    }

    @PatchMapping("/list/{id}")
    public ResponseEntity<ResponseUserDTO> updatePassword(@PathVariable Long id, @RequestBody UserPasswordDTO userPasswordDTO){
        User updatedPassword = userService.updatePassword(id, userPasswordDTO.getActualPassword(), userPasswordDTO.getNewPassword(), userPasswordDTO.getConfirmPassword());
        return ResponseEntity.ok(UserMapper.toUserDto(updatedPassword));

    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/list/{id}")
     public ResponseEntity<ResponseUserDTO> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toUserDto(user));

    }


}