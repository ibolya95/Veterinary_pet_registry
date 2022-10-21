package com.example.petclinic.services;

import com.example.petclinic.models.dtos.PetListDto;
import org.springframework.stereotype.Service;

@Service
public interface PetService {

    PetListDto listAllPets();


}
