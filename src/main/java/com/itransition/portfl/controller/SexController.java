package com.itransition.portfl.controller;

import com.itransition.portfl.dto.SexDTO;
import com.itransition.portfl.model.Sex;
import com.itransition.portfl.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/sex")
public class SexController {

    @Autowired
    private SexService sexService;

    @GetMapping(value = "getAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(sexService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOneById(@PathVariable Integer id) {
        return ResponseEntity.ok(sexService.findById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody SexDTO sexDTO) {
        sexService.save(toSex(sexDTO));
        return new ResponseEntity<String>("good", HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> deleteSexById(@RequestBody int id) {
        sexService.delete(id);
        return ResponseEntity.ok("ok");
    }

    private Sex toSex(SexDTO sexDTO) {
        Sex sex = new Sex();
        sex.setName(sexDTO.getName());
        return sex;
    }
}
