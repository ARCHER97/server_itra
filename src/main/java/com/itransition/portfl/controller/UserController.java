package com.itransition.portfl.controller;

import com.itransition.portfl.dto.UserDTO;
import com.itransition.portfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Kulik Artur
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.getUserById(id));
    }

    @GetMapping(value = "/update")
    public ResponseEntity<?> updateUserById(@RequestParam int id) {
        return ResponseEntity.ok("update");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(headers, HttpStatus.OK);
    }

}
