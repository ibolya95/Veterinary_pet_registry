package com.example.petclinic.services;

import com.example.petclinic.models.Pet;
import com.example.petclinic.models.dtos.*;
import org.springframework.stereotype.Service;

@Service
public interface PetService {

    PetListDto listAllPets();
    PetCreatedResponseDto createNewPet(PetRequestDto petRequestDto);

    PetUpdateResponseDto updatePetById(Long id, PetRequestDto petRequestDto);

    PetDeleteResponseDto deletePet(Long id);




}
