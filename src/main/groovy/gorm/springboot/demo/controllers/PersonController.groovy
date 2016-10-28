package gorm.springboot.demo.controllers

import gorm.springboot.demo.model.Person
import gorm.springboot.demo.services.PersonService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by ahagopian on 10/27/2016.
 */
@RestController()
@RequestMapping("/persons")
@Slf4j
class PersonController {

    @Autowired
    PersonService personService

    @RequestMapping(value="/", method = RequestMethod.GET)
    def list() {
        return personService.getAllPersons()
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    def add(@RequestParam String lastName,@RequestParam String firstName) {
        log.info("received request for l=${lastName}, f=${firstName}")
        personService.save(new Person(lastName:lastName, firstName:firstName))

    }
}
