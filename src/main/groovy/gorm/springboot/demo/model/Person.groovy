package gorm.springboot.demo.model

import grails.persistence.Entity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Entity
@JsonIgnoreProperties(['dirtyPropertyNames', 'errors', 'dirty', 'attached', 'version'])
class Person {
    String lastName
    String firstName
}
