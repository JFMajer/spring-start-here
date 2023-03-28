package main;

import configuration.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

//        var s1 = c.getBean(CommentService.class);
//        var s2 = c.getBean(UserService.class);
//
//        boolean b = s1.getRepo() == s2.getRepo();
//        System.out.println(b);
    }
}
