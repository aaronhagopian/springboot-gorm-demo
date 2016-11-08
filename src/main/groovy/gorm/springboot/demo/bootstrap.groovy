package gorm.springboot.demo

import gorm.springboot.demo.model.Person
import gorm.springboot.demo.services.PersonService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
@Slf4j
class bootstrap implements CommandLineRunner {

    @Autowired
    PersonService personService

    @Override
    void run(String... args) throws Exception {
        log.info("bootstrapping...")

        // do some bootstrap work here
        personService.save(new Person(lastName:"Bryant", firstName:"Kris"))
        personService.save(new Person(lastName:"Rizzo", firstName:"Anythony"))
        personService.save(new Person(lastName:"Schwarber", firstName:"Kyle"))

        log.info("done boostrapping")
    }
}
