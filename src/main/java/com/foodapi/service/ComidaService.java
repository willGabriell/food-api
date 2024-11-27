package com.foodapi.service;

import com.foodapi.model.Comida;
import com.foodapi.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaService {

    @Autowired
    ComidaRepository repository;

    public Comida save(Comida comida) {
        return repository.save(comida);
    }

    public List<Comida> findAll() {
        return repository.findAll();
    }

    public Comida findById(int id) {
        return repository.findById(id).get();
    }

    public List<Comida> findByNome(String titulo) {
        return repository.findByNomeContainingIgnoreCase(titulo);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
