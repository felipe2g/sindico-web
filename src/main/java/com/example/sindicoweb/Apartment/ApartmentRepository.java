package com.example.sindicoweb.Apartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApartmentRepository {

    @Autowired
    JdbcTemplate jdbc;

    public List<Apartment> findAll() {
         return jdbc.query(
            "SELECT id, doorNumber, roomCount, type FROM apartments",
            (rs, rowNum) -> new Apartment(
                    rs.getLong("id"),
                    rs.getInt("doorNumber"),
                    rs.getInt("roomCount"),
                    rs.getString("type")
            ));
    }

}
