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
@RequestMapping( value = "/tag" )
public class TagController {

    @GetMapping( value = "/getall" )
    public ResponseEntity<?> getAllTags(){
        return ResponseEntity.ok("tags");
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getTagsByImageId(@RequestParam int id){
        return ResponseEntity.ok("tags");
    }

}
