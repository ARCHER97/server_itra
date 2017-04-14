package com.itransition.portfl.controller;

import com.itransition.portfl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.profileService.findById(id));
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.profileService.findByUserId(id));
    }

    @GetMapping(value = "/rating")
    public ResponseEntity<?> getRatingById(@RequestParam int id) {
        return ResponseEntity.ok(this.profileService.findByUserId(id));
    }

}
