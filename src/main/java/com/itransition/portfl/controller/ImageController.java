package com.itransition.portfl.controller;

import com.itransition.portfl.model.Image;
import com.itransition.portfl.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Artur on 09.04.2017.
 */
@RestController
@RequestMapping( value = "/image" )
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    //Todo
    @GetMapping( value = "/getfirst" )
    public ResponseEntity<?> getFirstImageByUserId(@RequestParam int id){
        return ResponseEntity.ok("first image");
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getAllByUserId(@RequestParam int id){
        return ResponseEntity.ok(this.imageService.findAllByUserId(id));
    }

    @PostMapping( value = "/save" )
    public ResponseEntity<?> save(@RequestBody Image image){
        this.imageService.save(image);
        return ResponseEntity.ok("ok");
    }

    @PostMapping( value = "/remove" )
    public ResponseEntity<?> remove(@RequestBody int id){
        this.imageService.delete(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping( value = "/update" )
    public ResponseEntity<?> update(@RequestBody String image){
        return ResponseEntity.ok("update image");
    }

}
