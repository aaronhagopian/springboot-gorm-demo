package gorm.springboot.demo

import gorm.springboot.demo.services.PersonService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
//        (exclude = [DataSourceAutoConfiguration])
@EnableTransactionManagement
class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main, args);
    }
}