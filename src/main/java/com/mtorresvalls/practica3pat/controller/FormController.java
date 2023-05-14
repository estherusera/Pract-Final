package com.mtorresvalls.practica3pat.controller;


import java.util.ArrayList;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtorresvalls.practica3pat.service.Form;
import com.mtorresvalls.practica3pat.service.impl.FormServiceImpl;

@RestController
@RequestMapping("/api")
public class FormController {

    private FormServiceImpl formServiceImpl = new FormServiceImpl();
    private ArrayList<Form> forms = new ArrayList<>(); 
    
    @GetMapping("/getForms")
    public ResponseEntity<ArrayList<Form>> getForm(){        
        return new ResponseEntity<>(formServiceImpl.getForms(), HttpStatus.OK);
    }

    @GetMapping("/addNewForm/nombre={nombre}/email={email}/mensaje={mensaje}")
    public ResponseEntity<HttpStatus> addForm(@PathVariable String nombre, @PathVariable String email, @PathVariable String mensaje){

        if (nombre == "" || email == "" || mensaje == ""){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            forms = formServiceImpl.getForms();

            Form form = new Form(nombre, email, mensaje);
            form.setId(generateIndex());

            formServiceImpl.addForm(form);
        
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/deleteForm/param={parametro}")
    public ResponseEntity<HttpStatus> deleteForm(@PathVariable String parametro){
        if (parametro != null){
            formServiceImpl.deleteForm(parametro); 

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private int generateIndex(){
        ArrayList<Integer> indexes = new ArrayList<>();
        forms.forEach(form -> {
            indexes.add(form.getId());
        });

        Random r = new Random();

        int index = 1; 
        boolean indexEncontrado = !(indexes.contains(index)); 

        while (!indexEncontrado){
            index = r.nextInt(forms.size()+1);
            
            if (!(indexes.contains(index))){
                indexEncontrado = true; 
            }
        }


        return index; 
    }
}
