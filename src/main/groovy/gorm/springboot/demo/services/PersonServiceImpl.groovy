package gorm.springboot.demo.services

import gorm.springboot.demo.model.Person
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Implemenation of PersonService using GORM
 */
@Service('personService')
@Transactional
@Slf4j
class PersonServiceImpl implements PersonService {

    @Override
    List<Person> getAllPersons() {
        return Person.list()
    }

    @Override
    boolean save(Person p) {
        log.debug("saving person with id=${p.id}")
        p.save(true)
    }

    @Override
    Person getPerson(long id) {
        Person p = Person.get(id)
        if(p) {
            log.debug("request for ${id} found, ${p.lastName}, ${p.firstName}")
        } else {
            log.debug("no person with id=${id} found")
        }
        return p
    }
}
