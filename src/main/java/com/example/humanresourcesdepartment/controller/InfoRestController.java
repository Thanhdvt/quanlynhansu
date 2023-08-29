package com.example.humanresourcesdepartment.controller;

import com.example.humanresourcesdepartment.model.InfoRest;
import com.example.humanresourcesdepartment.service.InfoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/info-rest")
public class InfoRestController {

    @Autowired
    private InfoRestService infoRestService;

    @GetMapping
    public ResponseEntity<List<InfoRest>> getAllInfoRest() {
        List<InfoRest> list = infoRestService.getAllInfoRest();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoRest> getInfoRestById(@PathVariable("id") Long id) {
        InfoRest infoRest = infoRestService.getInfoRestById(id);
        return new ResponseEntity<>(infoRest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InfoRest> saveInfoRest(@RequestBody InfoRest infoRest) {
        InfoRest newInfoRest = infoRestService.addInfoRest(infoRest);
        return new ResponseEntity<>(newInfoRest, HttpStatus.OK);
    }
}
