package gorm.springboot.demo.controllers

import gorm.springboot.demo.model.Person
import gorm.springboot.demo.services.PersonService
import gorm.springboot.demo.services.PersonServiceImpl
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Controller for Person related requests
 */
@RestController()
@RequestMapping("/persons")
@Slf4j
class PersonController {

    @Autowired
    PersonService personService

    @RequestMapping(value="/", method = RequestMethod.GET)
    def list() {
        log.debug("received request for /persons/")
        return personService.getAllPersons()
    }

    @RequestMapping(value="/", method= RequestMethod.PUT)
    def add(@RequestParam String lastName,@RequestParam String firstName) {
        log.debug("received request for /persons/?lastName=${lastName}&firstName=${firstName}")
        personService.save(new Person(lastName:lastName, firstName:firstName))

    }

    @RequestMapping(value="/{id}/", method = RequestMethod.GET)
    def getById(@PathVariable("id") String id) {
        log.debug("received request for /persons/${id}/")
        def retVal = personService.getPerson(id.toLong())
        return retVal ?: []
    }
}
