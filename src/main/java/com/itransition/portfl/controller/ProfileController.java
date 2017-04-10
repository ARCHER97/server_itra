package com.itransition.portfl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Artur on 09.04.2017.
 */
@RestController
@RequestMapping( value = "/profile" )
public class ProfileController {

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getProfileById(@RequestParam int id){
        return ResponseEntity.ok("profile");
    }

    @GetMapping( value = "/rating" )
    public ResponseEntity<?> getRatingById(@RequestParam int id){
        return ResponseEntity.ok("rating");
    }

}
