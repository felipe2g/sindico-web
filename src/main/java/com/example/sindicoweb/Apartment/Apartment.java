package com.example.sindicoweb.Apartment;

import com.example.sindicoweb.Owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    public Long apartment_id;
    int door_number;
    int room_count;
    String type;
    Owner owner;
}
