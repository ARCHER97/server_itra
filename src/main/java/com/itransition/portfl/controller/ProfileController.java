package com.itransition.portfl.controller;

import com.itransition.portfl.service.ProfileService;
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
@RequestMapping( value = "/profile" )
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping( value = "/getbyuserid" )
    public ResponseEntity<?> getProfileByUserId(@RequestParam int id){
        return ResponseEntity.ok(this.profileService.findByUserId(id));
    }

    @GetMapping( value = "/rating" )
    public ResponseEntity<?> getRatingById(@RequestParam int id){
        return ResponseEntity.ok("rating");
    }

}
