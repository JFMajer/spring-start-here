package beans;

import beans.Parrot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Vasya";

    private Parrot parrot;

    // constructor with no arguments
    public Person() {
        this.parrot = null;
    }

    @Autowired
    public Person(@Qualifier("parrot1") Parrot parrot) {
        this.parrot = parrot;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public Parrot getParrot() {
        return parrot;
    }

}
