package aspects;

import models.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public void setLogger(Logger logger) { this.logger = logger; }

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Logging Aspect in action");
        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        Object returnedByMethod = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedByMethod);

        return returnedByMethod;
    }
}
