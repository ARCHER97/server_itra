package com.itransition.portfl.controller;

import com.itransition.portfl.dto.CommentDTO;
import com.itransition.portfl.security.JwtTokenHandler;
import com.itransition.portfl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Kulik Artur
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private CommentService commentService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public CommentController(CommentService commentService, JwtTokenHandler jwtTokenHandler) {
        this.commentService = commentService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<?> getCommentsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.commentService.findAllByImageId(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllComments() {
        return ResponseEntity.ok(this.commentService.findAll());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody CommentDTO commentDTO) {
        this.commentService.save(commentDTO);
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "/savenaxt")
    public ResponseEntity<?> saveNext(@RequestBody CommentDTO commentDTO,
                                      @RequestHeader(value = "jwt") String token) {
        Optional<UserDetails> userDetailsOptional = this.jwtTokenHandler.parseUserFromToken(token);
        userDetailsOptional.ifPresent(userDetails -> this.commentService.saveNext(commentDTO, userDetails));
        return ResponseEntity.ok("ok");
    }

}