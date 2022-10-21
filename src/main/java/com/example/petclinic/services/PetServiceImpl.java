package com.example.petclinic.services;

import com.example.petclinic.exceptions.NotFoundException;
import com.example.petclinic.models.Owner;
import com.example.petclinic.models.Pet;
import com.example.petclinic.models.dtos.*;
import com.example.petclinic.repositories.OwnerRepository;
import com.example.petclinic.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
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

    @Override
    public PetCreatedResponseDto createNewPet(PetRequestDto petRequestDto) {
        Pet pet = petRepository.save(
                new Pet(petRequestDto.getName(), petRequestDto.getType(),
                        petRequestDto.getSex(), ownerRepository.findById(petRequestDto.getOwnerId())
                                .orElseThrow( () -> new NotFoundException ("No owner found")))
        );
        return new PetCreatedResponseDto(
                pet.getPetId(),
                pet.getName(),
                pet.getOwner().getName()
        );
    }

    @Override
    public PetUpdateResponseDto updatePetById(Long id, PetRequestDto petRequestDto) {
        if(id == null) {
            throw new NotFoundException("No pet found");
        }
        Pet petToUpdate = petRepository.findById(id).orElseThrow( () -> new NotFoundException("Pet doesn't exist"));
        Owner owner = ownerRepository.findOwnerByOwnerId(petRequestDto.getOwnerId());
        petToUpdate.setName(petRequestDto.getName());
        petToUpdate.setType(petRequestDto.getType());
        petToUpdate.setSex(petRequestDto.getSex());
        petToUpdate.setOwner(owner);
        petRepository.save(petToUpdate);
        return new PetUpdateResponseDto("The owner of the pet has successfully changed");
    }
}
