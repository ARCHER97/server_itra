package com.itransition.portfl.controller;

import com.itransition.portfl.dto.CommentDTO;
import com.itransition.portfl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kulik Artur
 */
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/images/{id}")
    public ResponseEntity<?> getCommentsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.commentService.findAllByImageId(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody CommentDTO commentDTO) {
        this.commentService.save(commentDTO);
        return ResponseEntity.ok("ok");
    }

}