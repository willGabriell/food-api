package com.foodapi.controller;

import com.foodapi.model.Usuario;
import com.foodapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    @PostMapping("/login")
    public boolean login(@RequestBody Usuario u) {
        return service.autenticar(u.getUsername(), u.getSenha());
    }

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario u) {
        return service.salvar(u);
    }

}
