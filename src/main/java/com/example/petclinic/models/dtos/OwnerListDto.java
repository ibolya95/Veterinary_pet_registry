package com.example.petclinic.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OwnerListDto {

    private List<OwnerResponseDto> owners;

    public OwnerListDto(List<OwnerResponseDto> owners) {
        this.owners = owners;
    }

    public OwnerListDto() {
        this.owners = new ArrayList<>();
    }
}
