package com.example.petclinic.controllers;

import com.example.petclinic.models.dtos.PetListDto;
import com.example.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {
    private final PetService petService;

    @Autowired
    public PetRestController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public PetListDto listPets() {
        return petService.listAllPets();
    }


}
