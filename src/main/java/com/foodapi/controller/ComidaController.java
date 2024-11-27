package com.foodapi.controller;

import com.foodapi.model.Comida;
import com.foodapi.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    ComidaService service;

    @PostMapping
    public void save(@RequestBody Comida comida) {
        if(comida != null) {
            service.save(comida);
        }
    }

    @GetMapping
    public List<Comida> getAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Comida>> searchByName(@RequestParam String name) {
        List<Comida> l = service.findByNome(name);
        if(l.size() > 0) {
            return ResponseEntity.ok(l);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Comida> getById(@PathVariable int id) {
        Comida comida = service.findById(id);
        if (comida != null) {
            return ResponseEntity.ok(comida);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if(service.findById(id) != null) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
