package com.example.petclinic.controllers;

import com.example.petclinic.models.Owner;
import com.example.petclinic.models.dtos.OwnerCreatedResponseDto;
import com.example.petclinic.models.dtos.OwnerListDto;
import com.example.petclinic.models.dtos.OwnerRequestDto;
import com.example.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerRestController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerRestController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public OwnerListDto listAllOwners() {
        return ownerService.listAllOwners();
    }

    @PostMapping
    public ResponseEntity<OwnerCreatedResponseDto> addNewOwner(@RequestBody OwnerRequestDto ownerRequestDto) {
        return new ResponseEntity<>(ownerService.addNewOwner(ownerRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }
}
