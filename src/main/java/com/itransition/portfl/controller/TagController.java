package com.itransition.portfl.controller;

import com.itransition.portfl.dto.TagDTO;
import com.itransition.portfl.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/tags")
public class TagController {

    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.tagService.findAll());
    }

    @GetMapping(value = "/images/{id}")
    public ResponseEntity<?> getTagsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.tagService.findByImageId(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTag(@RequestBody TagDTO tagDTO) {
        this.tagService.save(tagDTO);
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "/saveall")
    public ResponseEntity<?> saveTags(@RequestBody TagDTO[] tagsDTO) {
        this.tagService.saveall(tagsDTO);
        return ResponseEntity.ok("ok");
    }

}