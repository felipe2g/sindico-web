package com.example.sindicoweb.Apartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    public Long id;
    int doorNumber;
    int roomCount;
    String type;
}
