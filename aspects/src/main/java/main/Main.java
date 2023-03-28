package main;

import configuration.Config;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        var c = new AnnotationConfigApplicationContext(Config.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Hello World!");
        comment.setAuthor("John Doe");

        service.publishComment(comment);
    }
}
