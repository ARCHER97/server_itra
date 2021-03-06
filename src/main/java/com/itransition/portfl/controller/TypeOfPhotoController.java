package com.itransition.portfl.controller;

import com.itransition.portfl.service.TypeOfPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kulik Artur
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/typeofphoto")
public class TypeOfPhotoController {

    private TypeOfPhotoService typeOfPhotoService;

    @Autowired
    public TypeOfPhotoController(TypeOfPhotoService typeOfPhotoService){
        this.typeOfPhotoService = typeOfPhotoService;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(typeOfPhotoService.findAll());
    }

}
