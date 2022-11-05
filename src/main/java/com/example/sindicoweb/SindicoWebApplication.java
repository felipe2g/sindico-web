package com.example.sindicoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SindicoWebApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbc;

    public static void main(String[] args) {
        SpringApplication.run(SindicoWebApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        jdbc.execute("DROP TABLE IF EXISTS owners");
        jdbc.execute("DROP TABLE IF EXISTS apartments");
        jdbc.execute("CREATE TABLE apartments(id SERIAL, doorNumber int, roomCount int, type varchar(20))");
        jdbc.execute("INSERT INTO apartments(doorNumber, roomCount, type) VALUES (100, 2, 'tipo 1'), (101, 2, 'tipo 2'), (200, 3, 'tipo 3') ");
    }
}
