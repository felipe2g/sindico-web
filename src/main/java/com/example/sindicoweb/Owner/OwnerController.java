package com.example.sindicoweb.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping()
    public String getOwner(Model model) {
        List<Owner> owners = ownerRepository.findAll();
        System.out.println("owners => "+ owners.toString());

        model.addAttribute("owners", owners);

        return("owner/list");
    }
}
