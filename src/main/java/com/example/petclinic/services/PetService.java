package com.example.petclinic.services;

import com.example.petclinic.models.Pet;
import com.example.petclinic.models.dtos.PetCreatedResponseDto;
import com.example.petclinic.models.dtos.PetListDto;
import com.example.petclinic.models.dtos.PetRequestDto;
import com.example.petclinic.models.dtos.PetUpdateResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface PetService {

    PetListDto listAllPets();
    PetCreatedResponseDto createNewPet(PetRequestDto petRequestDto);

    PetUpdateResponseDto updatePetById(Long id, PetRequestDto petRequestDto);




}
