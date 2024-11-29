package com.foodapi.service;

import com.foodapi.model.Usuario;
import com.foodapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public boolean autenticar(String username, String senha) {
        Usuario u = repository.findByUsername(username);
        return u != null && u.getSenha().equals(senha);
    }
}
