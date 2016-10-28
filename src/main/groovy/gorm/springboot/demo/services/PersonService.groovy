package gorm.springboot.demo.services

import gorm.springboot.demo.model.Person
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service('personService')
@Transactional
class PersonService {

    def getAllPersons() {
        return Person.list()
    }

    def save(Person p) {
        p.save(true)
    }

    def getPerson(long id) {
        return Person.get(id)
    }
}
