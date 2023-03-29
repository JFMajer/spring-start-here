package services;

import aspects.ToLog;
import models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private java.util.logging.Logger Logger;
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    public void publishComment(Comment comment) {
        logger.info("Publishing comment...: " + comment);
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment...: " + comment);
    }

    public void updateComment(Comment comment) {
        logger.info("Updating comment...: " + comment);
    }
}
