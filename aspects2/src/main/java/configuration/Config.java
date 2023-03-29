package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"repositories", "services", "proxies", "aspects"})
@EnableAspectJAutoProxy
public class Config {
}
