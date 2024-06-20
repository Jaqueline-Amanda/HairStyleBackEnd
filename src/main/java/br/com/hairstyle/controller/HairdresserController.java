package br.com.hairstyle.controller;

import br.com.hairstyle.dto.HairdresserDto;
import br.com.hairstyle.service.HairdresserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/hairdressers")
public class HairdresserController {
    @Autowired
    private HairdresserService service;
    @PostMapping
    public HairdresserDto create(@RequestBody HairdresserDto dto){
        return service.create(dto);
    }

    //    @GetMapping("/{id}")
//    public BrandModel findById(@PathVariable("id") int id){
//        return service.findById(id);
//    }
    @GetMapping("/{id}")
    public HairdresserDto findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping("/find/{name}")
    public List<HairdresserDto> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @GetMapping
    public List<HairdresserDto> findAll(){
        return service.findAll();
    }

    @PutMapping
    public HairdresserDto update(@RequestBody HairdresserDto dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}


