package com.itransition.portfl.controller;

import com.itransition.portfl.dto.PersonContext;
import com.itransition.portfl.dto.UserDTO;
import com.itransition.portfl.security.JwtTokenHandler;
import com.itransition.portfl.service.AuthService;
import com.itransition.portfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Kulik Artur
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private AuthService authService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public UserController(UserService userService, AuthService authService,
                          JwtTokenHandler jwtTokenHandler) {
        this.userService = userService;
        this.authService = authService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @PostMapping(value = "singup")
    public ResponseEntity<?> singup(@RequestBody PersonContext personContext) {
        String res = "";
        if (this.authService.singup(personContext.getUserDTO(),
                personContext.getProfileDTO(), personContext.getImageDTO())) {
            res = this.jwtTokenHandler.createTokenForUser(personContext.getUserDTO().toUser());
        }

        return ResponseEntity.ok(res);
    }

    @PostMapping(value = "login")
    public ResponseEntity login(@Valid @RequestBody UserDTO userDTO) {
        String res = "";
        if (this.authService.login(userDTO)) {
            res = this.jwtTokenHandler.createTokenForUser(userDTO.toUser());
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "isadmin")
    public ResponseEntity<?> isadmin(@RequestHeader(value = "jwt") String jwt) {
        UserDetails userDetails = null;
        Optional<UserDetails> userDetailsOptional = this.jwtTokenHandler.parseUserFromToken(jwt);
        if(userDetailsOptional.isPresent()){
            userDetails = userDetailsOptional.get();
        }
        return ResponseEntity.ok(this.userService.isAdmin(userDetails));
    }

}
