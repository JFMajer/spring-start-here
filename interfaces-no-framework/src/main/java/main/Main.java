package main;

import model.Comment;
import proxies.EmailNotificationproxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {

        public static void main(String[] args) {
            var commentRepository = new DBCommentRepository();
            var commentNotificationProxy = new EmailNotificationproxy();

            var commentService = new CommentService(commentRepository, commentNotificationProxy);
            var comment = new Comment();
            comment.setAuthor("John Doe");
            comment.setText("This is a comment");

            commentService.publishComment(comment);

        }
}
