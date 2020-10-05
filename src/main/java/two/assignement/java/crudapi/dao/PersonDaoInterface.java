package two.assignement.java.crudapi.dao;

import two.assignement.java.crudapi.entity.Person;

import java.util.List;

public interface PersonDaoInterface {


    public List<Person>findAll();
    public Person getPersonById(int id);
    public void addPerson(Person person);
    public void deletePerson(int id);



}
