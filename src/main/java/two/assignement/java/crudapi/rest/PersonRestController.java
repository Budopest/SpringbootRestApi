package two.assignement.java.crudapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.assignement.java.crudapi.ApplicationExceptions.PersonNotFoundException;
import two.assignement.java.crudapi.dao.PersonDaoInterface;
import two.assignement.java.crudapi.entity.Person;
import two.assignement.java.crudapi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable int id){
        Person requiredPerson = personService.getPersonById(id);
        if(requiredPerson==null){
            throw new PersonNotFoundException("Employee id not found: " + id);
        }
        return requiredPerson;
    }
    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person newPerson){
        newPerson.setId(0);
        personService.addPerson(newPerson);
        return newPerson;
    }
    @PutMapping("/persons/{id}")
    public Person updatePerson(@PathVariable int id,@RequestBody Person person){
        Person requiredPerson = personService.getPersonById(id);
        if(requiredPerson==null){
            throw new PersonNotFoundException("Employee id not found: "+id);
        }
        requiredPerson.setFirstName(person.getFirstName());
        requiredPerson.setLastName(person.getLastName());
        //personService.addPerson(person);
        return requiredPerson;
    }
    @DeleteMapping("/persons/{id}")
    public String deletePerson(@PathVariable int id){
        Person requiredPerson = personService.getPersonById(id);
        if(requiredPerson==null){
            throw new PersonNotFoundException("Employee id not found: "+id);
        }
        personService.deletePerson(id);
        return "person with id: "+id+" Deleted";
    }




}
