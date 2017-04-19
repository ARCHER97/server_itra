package com.itransition.portfl.controller;

import com.itransition.portfl.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kulik Artur
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/top")
public class TopController {

    private TopService topService;

    @Autowired
    public TopController(TopService topService) {
        this.topService = topService;
    }

    @GetMapping(value = "/get/{col}")
    public ResponseEntity<?> getAll(@PathVariable Integer col) {
        return ResponseEntity.ok(this.topService.findTop(col));
    }

}
