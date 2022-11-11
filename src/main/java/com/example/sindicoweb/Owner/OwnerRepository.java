package com.example.sindicoweb.Owner;

import com.example.sindicoweb.Apartment.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository {

    @Autowired
    JdbcTemplate jdbc;

    public List<Owner> findAll() {
        return jdbc.query(
    "SELECT owner_id, name, phone FROM owners",
        (rs, rowNum) -> new Owner(
                rs.getLong("owner_id"),
                rs.getString("name"),
                rs.getString("phone")
        ));
    }
}
