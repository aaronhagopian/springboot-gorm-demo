package gorm.springboot.demo

import gorm.springboot.demo.services.PersonService
import gorm.springboot.demo.services.PersonServiceImpl
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.*
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
//        (exclude = [DataSourceAutoConfiguration])
@EnableTransactionManagement
class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main, args);
    }
}