package com.example.dtoTestProject.mapper;

import com.example.dtoTestProject.dto.PersonDto;
import com.example.dtoTestProject.model.PersonEntity;
import com.example.dtoTestProject.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity toEntity(PersonDto personDto)
    {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setSurname(personDto.getSurname());
        personEntity.setName(personDto.getName());
        personEntity.setAge(personDto.getAge());

        return personEntity;
    }

    public PersonDto toDto(PersonEntity personEntity)
    {
        return PersonDto
                .builder()
                .surname(personEntity.getSurname())
                .name(personEntity.getName())
                .age(personEntity.getAge())
                .build();
    }



}
