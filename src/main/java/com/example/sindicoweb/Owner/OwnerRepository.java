package com.example.sindicoweb.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository {

    @Autowired
    JdbcTemplate jdbc;
}
