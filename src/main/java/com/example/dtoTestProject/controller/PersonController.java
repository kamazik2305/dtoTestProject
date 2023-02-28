package com.example.dtoTestProject.controller;

import com.example.dtoTestProject.dto.PersonDto;
import com.example.dtoTestProject.model.PersonEntity;
import com.example.dtoTestProject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    //@Autowired
    private final PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getAllPersonsDto()
    {
        return  personService.findAllPersonsDto();
    }

    @GetMapping("/persons/{id_person}")
    public PersonDto getPersonById(@PathVariable(value = "id_person") long id)
    {
        return personService.findPersonById(id);
    }

    @PostMapping("/persons/age")
    public PersonDto getPersonByAge(@RequestParam int age)
    {
        return personService.findPersonByAge(age);
    }

    @PostMapping("/persons/name")
    public PersonDto getPersonByName(@RequestParam String name)
    {
        return personService.findPersonByName(name);
    }

    @PostMapping("/persons/add")
    public PersonDto addPerson(@RequestBody PersonDto personDto)
    {
        return personService.addPerson(personDto);
    }

    @PutMapping("/persons/update/{id_person}")
    public PersonDto updatePerson(@PathVariable(value = "id_person") long idPerson,
                                  @RequestBody PersonDto personDto)
    {
        return personService.updatePerson(idPerson, personDto);
    }

    @DeleteMapping("/persons/delete/{id_person}")
    public ResponseEntity deletePerson(@PathVariable(value = "id_person") long idPerson)
    {
        personService.deletePerson(idPerson);
        return ResponseEntity.ok("Петух послан нахуй");
    }
}
