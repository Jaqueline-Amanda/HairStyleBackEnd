package br.com.hairstyle.controller;

import br.com.hairstyle.dto.ClientDto;
import br.com.hairstyle.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService service;
    @PostMapping
    public ClientDto create(@RequestBody ClientDto dto){
        return service.create(dto);
    }

    //    @GetMapping("/{id}")
//    public BrandModel findById(@PathVariable("id") int id){
//        return service.findById(id);
//    }
    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping("/find/{name}")
    public List<ClientDto> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @GetMapping
    public List<ClientDto> findAll(){
        return service.findAll();
    }

    @PutMapping
    public ClientDto update(@RequestBody ClientDto dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}


