package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import repositories.CommentRepository;

@Service
@Lazy
public class UserService {

    private final CommentRepository repo;

    public UserService(CommentRepository repo) {
        this.repo = repo;
        System.out.println("UserService constructor called");
    }

    public CommentRepository getRepo() {
        return repo;
    }
}
