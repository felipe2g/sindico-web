package com.example.sindicoweb.Apartment;

import com.example.sindicoweb.Owner.Owner;
import com.example.sindicoweb.Owner.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApartmentRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    OwnerRepository ownerRepository;

    public List<Apartment> findAll() {
         return jdbc.query(
            "SELECT a.apartment_id, a.door_number, a.room_count, a.type, a.owner_id, o.\"name\", o.phone FROM apartments a INNER JOIN owners o ON a.owner_id = o.owner_id",
            (rs, rowNum) -> new Apartment(
                    rs.getLong("apartment_id"),
                    rs.getInt("door_number"),
                    rs.getInt("room_count"),
                    rs.getString("type"),
                    new Owner(rs.getLong("owner_id"), rs.getString("name"), rs.getString("phone"))
            ));
    }

    public void create(Apartment apartment) {
        jdbc.update("INSERT INTO apartments(door_number, room_count, type, owner_id) VALUES (?, ?, ?, ?)",
                apartment.getDoor_number(), apartment.getRoom_count(), apartment.getType(), 1);
    }
}
