package com.example.dtoTestProject.repository;

import com.example.dtoTestProject.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByName(String name);
    PersonEntity findByAge(int age);
}
