package com.yahia.crud_springBoot;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")

public class PersonController {

    final PersonRepository personRepository;

    public PersonController (PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){

        if(person.getName().length()>2){
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);}
        else {
            throw new IllegalArgumentException("Name is too short");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseThrow(()->new PersonNotFoundException("Ohhhh !! Person Not Found"));


    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person personDetails){
        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()){
            Person existingPerson = person.get();
            existingPerson.setCity(personDetails.getCity());
            existingPerson.setPhoneNumber(personDetails.getPhoneNumber());

            personRepository.save(existingPerson);
            return new ResponseEntity<>(existingPerson, HttpStatus.OK);
        }
        throw new PersonNotFoundException("Ohhhh !! Person Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            personRepository.delete(person.get());
            return new ResponseEntity<>( HttpStatus.OK);

        }
        throw new PersonNotFoundException("Ohhhh !! Person Not Found");
    }





}
