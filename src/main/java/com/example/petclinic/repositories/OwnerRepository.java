package com.example.petclinic.repositories;

import com.example.petclinic.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findOwnerByOwnerId(Long id);

}
