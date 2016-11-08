package gorm.springboot.demo.services

import gorm.springboot.demo.model.Person

/**
 * Interface for dealing with Person model.
 */
interface PersonService {
    List<Person> getAllPersons()

    boolean save(Person p)

    Person getPerson(long id)
}
