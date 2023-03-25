package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import main.Parrot;
import main.Person;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Polly");
        return p;
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("John");
        p.setParrot(parrot());
        return p;
    }

}
