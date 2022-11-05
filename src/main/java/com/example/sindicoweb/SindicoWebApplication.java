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
        jdbc.execute("DROP TABLE IF EXISTS apartments");
        jdbc.execute("DROP TABLE IF EXISTS owners");
        jdbc.execute("""
            CREATE TABLE owners(
            owner_id SERIAL, 
            name varchar(50), 
            phone varchar(15),
            PRIMARY KEY(owner_id))
        """);
        jdbc.execute("""
            CREATE TABLE apartments(
            apartment_id SERIAL,
            door_number int,
            room_count int,
            type varchar(20),
            owner_id int,
            PRIMARY KEY(apartment_id),
            CONSTRAINT fk_owner
            FOREIGN KEY(owner_id)
            REFERENCES owners(owner_id))
        """);
        jdbc.execute("""
            INSERT INTO owners(name, phone) VALUES 
            ('Felipe', '1'), 
            ('Ana', '2'), 
            ('Babababa', '3'), 
            ('Felipe', '4')
        """);
        jdbc.execute("""
            INSERT INTO apartments(door_number, room_count, type, owner_id) VALUES 
            (100, 2, 'tipo 1', 1), 
            (101, 2, 'tipo 2', 2), 
            (200, 3, 'tipo 3', 3), 
            (201, 4, 'tipo 5', 3), 
            (300, 2, 'tipo 10', 4)
        """);
    }
}
