package com.example.sindicoweb.Apartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApartmentController {

    @Autowired
    ApartmentRepository apartmentRepository;

    @GetMapping("/apartment")
    public String getApartment(Model model) {
        List<Apartment> apartments = apartmentRepository.findAll();

        model.addAttribute("apartments", apartments);

        return "apartment/list";
    }
}
