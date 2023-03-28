package services;

import models.Comment;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    public void publishComment(Comment comment) {
        System.out.println("Publishing comment: " + comment);
    }
}
