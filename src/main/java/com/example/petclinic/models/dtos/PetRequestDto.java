package com.example.petclinic.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetRequestDto{
    private String name;
    private String type;
    private String sex;
    private Long ownerId;

}
