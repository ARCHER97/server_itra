package com.itransition.portfl.controller;

import com.itransition.portfl.dto.AddRatingInfoDTO;
import com.itransition.portfl.security.JwtTokenHandler;
import com.itransition.portfl.service.RatingService;
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
@RequestMapping(value = "rating")
public class RatingController {

    private JwtTokenHandler jwtTokenHandler;
    private RatingService ratingService;

    @Autowired
    public RatingController(JwtTokenHandler jwtTokenHandler, RatingService ratingService) {
        this.jwtTokenHandler = jwtTokenHandler;
        this.ratingService = ratingService;
    }

    @PostMapping(value = "add")
    public ResponseEntity<?> addLike(@RequestBody AddRatingInfoDTO addRatingInfoDTO,
                                     @RequestHeader("jwt") String jwt) {
        Optional<UserDetails> userDetailsOptional = this.jwtTokenHandler.parseUserFromToken(jwt);
        userDetailsOptional.ifPresent(userDetails -> this.ratingService.addRating(addRatingInfoDTO, userDetails));
        return ResponseEntity.ok("ok");
    }
}
