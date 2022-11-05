package com.example.sindicoweb.Owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    public Long owner_id;
    public String name;
    public String phone;
}
