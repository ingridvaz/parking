package com.api.rest.parking.web.controller;

import com.api.rest.parking.entity.User;
import com.api.rest.parking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User users = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @PatchMapping("/list/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @RequestBody User user){
        User updatedPassword = userService.updatePassword(id, user.getPassword());
        return ResponseEntity.ok(user);

    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/list/{id}")
     public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);

    }


}