package com.example.petclinic.services;

import com.example.petclinic.models.Owner;
import com.example.petclinic.models.dtos.OwnerCreatedResponseDto;
import com.example.petclinic.models.dtos.OwnerListDto;
import com.example.petclinic.models.dtos.OwnerRequestDto;
import com.example.petclinic.models.dtos.OwnerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {

    OwnerListDto listAllOwners();

    OwnerCreatedResponseDto addNewOwner(OwnerRequestDto ownerRequestDto);

    void deleteOwner(Long id);

    void updateOwner(Long id, OwnerRequestDto ownerRequestDto);
}
