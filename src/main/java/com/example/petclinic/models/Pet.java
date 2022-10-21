package com.example.petclinic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long petId;
    private String name;
    private String type;
    private String sex;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public Pet(String name, String type, String sex, Owner owner) {
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.owner = owner;
    }
}
