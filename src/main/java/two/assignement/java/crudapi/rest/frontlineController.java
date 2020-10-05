package two.assignement.java.crudapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.assignement.java.crudapi.entity.Person;

import java.util.List;

@RestController
@RequestMapping("/api")
public class frontlineController {

    @Autowired
    PersonRestController personRestController;

    @GetMapping("/frontline")
    public List<Person> findAll(){
        return personRestController.findAll();
    }

    @GetMapping("/frontline/{id}")
    public Person getPerson(@PathVariable int id){
        return personRestController.getPerson(id);

    }

    @PostMapping("/frontline")
    public Person addPerson(@RequestBody Person newPerson){
        return personRestController.addPerson(newPerson);

    }
    @PutMapping("/frontline/{id}")
    public Person updatePerson(@PathVariable int id,@RequestBody Person person){
        return personRestController.updatePerson(id,person);

    }
    @DeleteMapping("/frontline/{id}")
    public String deletePerson(@PathVariable int id){
        return personRestController.deletePerson(id);
    }




}
