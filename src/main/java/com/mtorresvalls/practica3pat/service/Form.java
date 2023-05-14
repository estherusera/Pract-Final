package com.mtorresvalls.practica3pat.service;

import java.io.Serializable;

public class Form implements Serializable{
    private String nombre; 
    private String email; 
    private String mensaje;
    private int id; 

    public Form(){

    }

    public Form(int id, String nombre, String email, String mensaje){
        this.id = id; 
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
    }
    
    public Form(String nombre, String email, String mensaje) {
        this(0, nombre, email, mensaje);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;  
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public String toString(){
        return "id: " + id +
        ", nombre: " + nombre + 
        ", email: " + email + 
        ", mensaje: " + mensaje;
    }
}
