package com.example.petclinic.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PetListDto {
    private List<PetResponseDto> petList;

    public PetListDto(List<PetResponseDto> petList) {
        this.petList = petList;
    }

    public PetListDto() {
        petList = new ArrayList<>();
    }


}
