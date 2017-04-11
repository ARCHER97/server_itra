package com.itransition.portfl.controller;

import com.itransition.portfl.service.TagService;
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
@RequestMapping( value = "/tag" )
public class TagController {

    private TagService tagService;

    @Autowired
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping( value = "/getall" )
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.tagService.findAll());
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getTagsByImageId(@RequestParam int id){
        return ResponseEntity.ok("tags");
    }

}
