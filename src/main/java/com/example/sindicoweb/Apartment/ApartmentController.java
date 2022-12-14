package com.example.sindicoweb.Apartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("apartment")
public class ApartmentController {

    @Autowired
    ApartmentRepository apartmentRepository;

    @GetMapping()
    public String getApartment(Model model) {
        List<Apartment> apartments = apartmentRepository.findAll();

        model.addAttribute("apartments", apartments);

        return "apartment/list";
    }

    @GetMapping("/new")
    public String showCreateApartmentForm(Model model) {
        model.addAttribute("apartment", new Apartment());
        return "apartment/new";
    }

    @PostMapping("/new")
    public String createApartment(Apartment apartment) {
        apartmentRepository.create(apartment);
        return "redirect:/apartment";
    }
}
