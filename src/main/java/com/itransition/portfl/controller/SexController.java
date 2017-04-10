package com.itransition.portfl.controller;

import com.itransition.portfl.dto.SexDTO;
import com.itransition.portfl.model.Sex;
import com.itransition.portfl.repository.SexRepository;
import com.itransition.portfl.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Artur on 09.04.2017.
 */
@RestController
@RequestMapping(value = "/sex")
public class SexController {

    @Autowired
    private SexRepository sexRepository;

    @Autowired
    private SexService sexService;

    @GetMapping(value = "/getall")
    public ResponseEntity<?> findAll() {
        System.out.println(sexService.findAll());
        return ResponseEntity.ok(sexService.findAll());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> findOneSexById(@RequestParam int id) {
        return ResponseEntity.ok(sexService.findOneSexById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody SexDTO sexDTO) {
        sexService.save(toSex(sexDTO));
        return new ResponseEntity("good", HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> deleteSexById(@RequestParam int id) {
        sexService.deleteSexById(id);
        return new ResponseEntity("good", HttpStatus.CREATED);
    }

    public Sex toSex(SexDTO sexDTO){
        Sex sex = new Sex();
        sex.setName(sexDTO.getName());
        return sex;
    }
}
