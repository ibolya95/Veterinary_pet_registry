package com.example.petclinic.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerResponseDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

}
