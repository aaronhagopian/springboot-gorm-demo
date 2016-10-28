package gorm.springboot.demo

import gorm.springboot.demo.model.Person
import gorm.springboot.demo.services.PersonService
import grails.transaction.Transactional
import groovy.util.logging.Slf4j
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.EnableTransactionManagement
import spock.lang.Specification

//@RunWith(SpringRunner)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class PersonSpec extends Specification {

    @Autowired PersonService personService

    def 'Persist a person'() {
        when: "Person to add"
        def p = new Person(lastName:"Rizzo", firstName:"Anthony")

        then: "Persist that person"
        personService.save(p)

        expect: "Person to be saved"
        personService.getAllPersons().size() > 0
        personService.getPerson(p.id).lastName == p.lastName
    }
}
