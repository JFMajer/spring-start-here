package aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class SecurityAspect {
    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around(value = "@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Aspect in action");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Security Aspect: Method executed and returned " + returnedByMethod);
        return returnedByMethod;
    }

}
