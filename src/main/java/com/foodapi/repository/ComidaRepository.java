package com.foodapi.repository;

import com.foodapi.model.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComidaRepository extends JpaRepository<Comida, Integer> {

    List<Comida> findByNomeContainingIgnoreCase(String titulo);

}