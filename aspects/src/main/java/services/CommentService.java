package services;

import models.Comment;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    public String publishComment(Comment comment) {
        System.out.println("Publishing comment...: " + comment);
        return "Success";
    }
}
