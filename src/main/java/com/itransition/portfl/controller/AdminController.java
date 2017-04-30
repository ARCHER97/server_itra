package com.itransition.portfl.controller;

import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.security.JwtTokenHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kulik Artur
 */
@CrossOrigin
@RestController
@RequestMapping(value = "admin")
public class AdminController {

    private ProfileRepository profileRepository;
    private JwtTokenHandler jwtTokenHandler;

//    @GetMapping(value = "getAll")
//    public
}
