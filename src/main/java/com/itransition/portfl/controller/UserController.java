package com.itransition.portfl.controller;

import com.itransition.portfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Artur on 09.04.2017.
 */
@RestController
@RequestMapping( value = "/user" )
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping( value = "/getall" )
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getUserById(@RequestParam int id){
        return ResponseEntity.ok(this.getUserById(id));
    }

    @GetMapping( value = "/update" )
    public ResponseEntity<?> updateUserById(@RequestParam int id){
        return ResponseEntity.ok("update");
    }

}
