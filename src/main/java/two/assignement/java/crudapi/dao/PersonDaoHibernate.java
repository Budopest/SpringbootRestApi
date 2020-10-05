package two.assignement.java.crudapi.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import two.assignement.java.crudapi.entity.Person;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonDaoHibernate implements PersonDaoInterface {

    private EntityManager entityManager;

    @Autowired
    public PersonDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Person> getAllQuery = session.createQuery("from Person",Person.class);
        List<Person> persons = getAllQuery.getResultList();
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Person.class,id);
    }

    @Override
    public void addPerson(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(person);
    }

    @Override
    public void deletePerson(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Person> deleteQuery = session.createQuery("delete from Person where id=:id");
        deleteQuery.setParameter("id",id);
        deleteQuery.executeUpdate();

    }
    public boolean exists(int id){
        Session session = entityManager.unwrap(Session.class);
        if(session.get(Person.class,id)==null) return false;
        return true;
    }
}
