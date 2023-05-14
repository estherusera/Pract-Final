package com.mtorresvalls.practica3pat.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.mtorresvalls.practica3pat.model.UserModel;

public interface UserService {
    Iterable<UserModel> getUsuarios();

    void createUser(UserModel usuario);

    UserModel getUsuarios(String username);

    void loginUsuario(UserModel usuario);
}
