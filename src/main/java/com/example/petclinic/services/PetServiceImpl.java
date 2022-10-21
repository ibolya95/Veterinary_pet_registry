package com.example.petclinic.services;

import com.example.petclinic.models.Pet;
import com.example.petclinic.models.dtos.PetListDto;
import com.example.petclinic.models.dtos.PetResponseDto;
import com.example.petclinic.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public PetListDto listAllPets() {
        PetListDto petListDto = new PetListDto();
        List<Pet> listPets = petRepository.findAll();

        for(Pet pet : listPets) {
            PetResponseDto petResponseDto = new PetResponseDto(
                    pet.getName(),
                    pet.getType(),
                    pet.getSex(),
                    pet.getOwner().getName(),
                    pet.getOwner().getAddress(),
                    pet.getOwner().getPhoneNumber()
            );
            petListDto.getPetList().add(petResponseDto);
        }
        return petListDto;
    }
}
