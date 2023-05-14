package com.mtorresvalls.practica3pat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mtorresvalls.practica3pat.model.UserModel;
import com.mtorresvalls.practica3pat.repository.UserRepository;
import com.mtorresvalls.practica3pat.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public Iterable<UserModel> getUsuarios() {
        return repository.findAll();

    }

    @Override
    public void createUser(UserModel usuario) {
        repository.insertDocument(usuario.getUserId(), usuario.getUsername(), usuario.getEmail(),
                usuario.getPassword());
    }

    @Override
    public UserModel getUsuarios(String username) {
        UserModel response = null;
        if (repository.existsById(username)) {
            Iterable<UserModel> usuarios = repository.getUsuarios(username);
            for (UserModel u : usuarios) {
                response = u;
            }
            return response;
        }
        return response;

    }

    @Override
    public void loginUsuario(UserModel usuario) {
        System.out.println(repository.buscarUsuario(usuario.getUsername()));
    }

}
