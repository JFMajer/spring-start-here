package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    Parrot parrot() {
        return new Parrot("Polly");
    }

    @Bean
    Parrot parrot2() {
        return new Parrot("Koko");
    }

    @Bean
    Parrot parrot3() {
        return new Parrot("Kesha");
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer nine() {
        return 9;
    }

}
