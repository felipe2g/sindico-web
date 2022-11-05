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
            "SELECT apartment_id, door_number, room_count, type FROM apartments",
            (rs, rowNum) -> new Apartment(
                    rs.getLong("apartment_id"),
                    rs.getInt("door_number"),
                    rs.getInt("room_count"),
                    rs.getString("type")
            ));
    }

}
