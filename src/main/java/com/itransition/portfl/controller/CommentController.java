package com.itransition.portfl.controller;

import com.itransition.portfl.model.Comment;
import com.itransition.portfl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Artur on 09.04.2017.
 */
@RestController
@RequestMapping( value = "/comment" )
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping( value = "/get")
    public ResponseEntity<?> getCommentsByImageId(@RequestParam int id){
        return ResponseEntity.ok(this.commentService.findAllByImageId(id));
    }

    @PostMapping( value = "/save" )
    public ResponseEntity<?> save(@RequestBody Comment comment){
        this.commentService.save(comment);
        return ResponseEntity.ok("ok");
    }

}
