package com.itransition.portfl.controller;

import com.itransition.portfl.model.Image;
import com.itransition.portfl.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kulik Artur
 */
@RestController
@RequestMapping(value = "/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/getfirst")
    public ResponseEntity<?> getFirstImageByUserId(@RequestParam int id) {
        return ResponseEntity.ok(this.imageService.findFirstByUserId(id));
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getAllByUserId(@RequestParam int id) {
        return ResponseEntity.ok(this.imageService.findAllByUserId(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody Image image) {
        this.imageService.save(image);
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> remove(@RequestBody int id) {
        this.imageService.delete(id);
        return ResponseEntity.ok("ok");
    }

}
