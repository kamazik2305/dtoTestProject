package com.example.dtoTestProject.service;

import com.example.dtoTestProject.dto.PersonDto;
import com.example.dtoTestProject.mapper.PersonMapper;
import com.example.dtoTestProject.model.PersonEntity;
import com.example.dtoTestProject.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    //@Autowired
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDto> findAllPersonsDto()
    {
        return personRepository
                .findAll()
                .stream()
                .map(personEntity -> PersonDto.builder()
                        .surname(personEntity.getSurname())
                        .name(personEntity.getName())
                        .age(personEntity.getAge())
                        .build())
                .toList();
    }

    public List<PersonEntity> findPersonsEntity()
    {
        return personRepository.findAll().stream().toList();
    }

    public PersonDto findPersonById(long id)
    {
        return personMapper.toDto(personRepository.findById(id).get());
    }

    public PersonDto findPersonByName(String name)
    {
        return personMapper.toDto(personRepository.findByName(name));
    }

    public PersonDto findPersonByAge(int age)
    {
        return personMapper.toDto(personRepository.findByAge(age));
    }


    public PersonDto addPerson(PersonDto personDto)
    {
        PersonEntity personEntity = personMapper.toEntity(personDto);
        personRepository.save(personEntity);

        return  PersonDto
                .builder()
                .surname(personEntity.getSurname())
                .name(personEntity.getName())
                .age(personEntity.getAge())
                .build();
    }

    public PersonDto updatePerson(long id, PersonDto personDto)
    {
        PersonEntity personEntity = personRepository.findById(id).orElseThrow();
        personEntity.setSurname(personDto.getSurname());
        personEntity.setName(personDto.getName());
        personEntity.setAge(personDto.getAge());
        personRepository.save(personEntity);
        return personDto;
    }

    public void deletePerson(long id)
    {
        personRepository.deleteById(id);
    }

}
