package com.mtorresvalls.practica3pat.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.mtorresvalls.practica3pat.service.DataSourceConfiguration;
import com.mtorresvalls.practica3pat.service.Form;

public class FormServiceImpl {

    DataSourceConfiguration dataSourceConfiguration = new DataSourceConfiguration();

    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConfiguration.getDataSource()); 

    @Transactional
    public void addForm(Form form){
        String query = "INSERT INTO formularios (ID, NOMBRE, EMAIL, MENSAJE) VALUES (" +
        form.getId() + ", '" + form.getNombre() + "', '" + form.getEmail() + "', '" + 
        form.getMensaje()+ "')";

        jdbcTemplate.execute(query);
    }

    @Transactional
    public ArrayList<Form> getForms(){
        String query = "SELECT * FROM formularios";
        
        RowMapper<Form> rowMapper = new RowMapper<Form>() {
            public Form mapRow(ResultSet rs, int rowNum) throws SQLException{
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String mensaje = rs.getString("mensaje");
                return new Form(id, nombre, email, mensaje);
            }
        };

        List<Form> formularios = jdbcTemplate.query(query, rowMapper);

        return new ArrayList<>(formularios);
    }

    @Transactional
    public void deleteForm(String id){
        String query = "DELETE FROM formularios WHERE id=" + id;

        jdbcTemplate.execute(query);
    }
}