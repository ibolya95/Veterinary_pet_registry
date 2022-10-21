package com.example.petclinic.services;

import com.example.petclinic.exceptions.NotFoundException;
import com.example.petclinic.models.Owner;
import com.example.petclinic.models.dtos.OwnerCreatedResponseDto;
import com.example.petclinic.models.dtos.OwnerListDto;
import com.example.petclinic.models.dtos.OwnerRequestDto;
import com.example.petclinic.models.dtos.OwnerResponseDto;
import com.example.petclinic.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerListDto listAllOwners() {
        OwnerListDto ownerListDto = new OwnerListDto();
        List<Owner> listOwners = ownerRepository.findAll();
        for(Owner owner : listOwners) {
            OwnerResponseDto ownerResponseDto = new OwnerResponseDto(
                    owner.getOwnerId(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getPhoneNumber()
            );
            ownerListDto.getOwners().add(ownerResponseDto);
        }
        return ownerListDto;
    }

    @Override
    public OwnerCreatedResponseDto addNewOwner(OwnerRequestDto ownerRequestDto) {
        Owner ownerToAdd = ownerRepository.save(
                new Owner(ownerRequestDto.getName(), ownerRequestDto.getAddress(), ownerRequestDto.getPhone())
        );
        return new OwnerCreatedResponseDto(ownerToAdd.getName(), "Owner has successfully added.");
    }

    @Override
    public void deleteOwner(Long id) {
        Owner ownerToDelete = ownerRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Owner not found"));
        ownerRepository.delete(ownerToDelete);
    }
}
