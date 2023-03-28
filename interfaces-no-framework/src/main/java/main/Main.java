package main;

import configuration.ProjectConfiguration;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.EmailNotificationproxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {

        public static void main(String[] args) {
            var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

            var comment = new Comment();
            comment.setText("This is a comment");
            comment.setAuthor("Jakub");

            var commentService = context.getBean(CommentService.class);
            commentService.publishComment(comment);

        }
}
