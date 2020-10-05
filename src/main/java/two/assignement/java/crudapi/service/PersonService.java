package two.assignement.java.crudapi.service;

import two.assignement.java.crudapi.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();
    public Person getPersonById(int id);
    public void addPerson(Person person);
    public void deletePerson(int id);
}
