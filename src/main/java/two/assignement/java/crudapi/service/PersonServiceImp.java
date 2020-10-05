package two.assignement.java.crudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import two.assignement.java.crudapi.dao.PersonDaoInterface;
import two.assignement.java.crudapi.entity.Person;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonDaoInterface personDao;

    @Override
    @Transactional
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDao.addPerson(person);

    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        personDao.deletePerson(id);

    }
}
