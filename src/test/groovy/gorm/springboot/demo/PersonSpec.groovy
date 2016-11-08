package gorm.springboot.demo

import gorm.springboot.demo.model.Person
import gorm.springboot.demo.services.PersonService
import gorm.springboot.demo.services.PersonServiceImpl
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.EnableTransactionManagement
import spock.lang.Specification

//@RunWith(SpringRunner)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes=[Main, Person])
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
