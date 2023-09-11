package com.example.humanresourcesdepartment.controller;

import com.example.humanresourcesdepartment.dto.InfoRestDto;
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
    public ResponseEntity<List<InfoRestDto>> getAllInfoRest() {
        List<InfoRestDto> list = infoRestService.getAllInfoRest();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoRestDto> getInfoRestById(@PathVariable("id") Long id) {
        InfoRestDto Dto = infoRestService.getInfoRestById(id);
        return new ResponseEntity<>(Dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InfoRestDto> saveInfoRest(@RequestBody InfoRestDto infoRestDto) {
        InfoRestDto newInfoRestDto = infoRestService.addInfoRest(infoRestDto);
        return new ResponseEntity<>(newInfoRestDto, HttpStatus.OK);
    }
}
