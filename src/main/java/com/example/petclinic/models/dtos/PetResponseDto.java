package com.example.petclinic.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetResponseDto {

    private String name;
    private String type;
    private String sex;
    private String owner;
    private String address;
    private String phone;

}
