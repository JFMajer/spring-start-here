package main;

import configuration.Config;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        System.out.println("Hello World!");

        var c = new AnnotationConfigApplicationContext(Config.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment("Hello World!", "John Doe");


        String value = service.publishComment(comment);
        logger.info("Returned value: " + value);
    }
}
