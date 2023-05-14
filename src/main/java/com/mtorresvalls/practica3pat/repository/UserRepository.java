package com.mtorresvalls.practica3pat.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mtorresvalls.practica3pat.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, String> {

    @Query("SELECT * FROM USERS WHERE USERS.USERNAME= :username")
    public Iterable<UserModel> getUsuarios(String username);

    @Query("SELECT * FROM USERS WHERE USERS.USERNAME= :username")
    public UserModel buscarUsuario(String username);

    @Modifying
    @Query("INSERT INTO USERS VALUES(:id,:name,:email,:password)")
    int insertDocument(
            @Param("id") Long userId,
            @Param("name") String username,
            @Param("email") String email,
            @Param("password") String password);

    // hacer un select

}

/*
 * String sql =
 * "INSERT INTO PORTFOLIO_MOVEMENTS (USER_ID, TICKER, QUANTITY, PRICE, DATE) VALUES (?, ?, ?, ?, ?)"
 * ;
 * 
 * jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
 * 
 * @Override
 * public void setValues(PreparedStatement pstmt, int i) throws SQLException {
 * PortfolioMovement movement = movements.get(i);
 * pstmt.setInt(1, movement.getUserId());
 * pstmt.setString(2, movement.getTicker());
 * pstmt.setInt(3, movement.getQuantity());
 * pstmt.setDouble(4, movement.getPrice());
 * pstmt.setDate(5, java.sql.Date.valueOf(movement.getDate()));
 * }
 */