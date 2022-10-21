package com.example.petclinic.controllers;

import com.example.petclinic.models.dtos.PetCreatedResponseDto;
import com.example.petclinic.models.dtos.PetListDto;
import com.example.petclinic.models.dtos.PetRequestDto;
import com.example.petclinic.models.dtos.PetUpdateResponseDto;
import com.example.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<PetCreatedResponseDto> addNewPet(@RequestBody PetRequestDto petRequestDto) {
        return new ResponseEntity<>(petService.createNewPet(petRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{petId}")
    public ResponseEntity<PetUpdateResponseDto> updatePet(@PathVariable Long petId,
                                                          @RequestBody PetRequestDto petRequestDto) {
        return new ResponseEntity<>(petService.updatePetById(petId, petRequestDto), HttpStatus.OK) ;
    }


}
