package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.CommentService;

@Configuration
@ComponentScan(basePackages = {"repositories", "services", "proxies"})
public class ProjectConfiguration {
}