package aspects;

import models.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Before("execution(* services.*.*(..))")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Timestamp: " + new Date());
//    }

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName + " called at " + new Date() + " with arguments: " + Arrays.asList(arguments));
        // logger.info("Method " + joinPoint.getSignature().getName() + " called at " + new Date() + "");
        Comment comment = new Comment("Hello!", "Jakub");
        Object [] newArguments = {comment};
        Object result = joinPoint.proceed(newArguments);
        logger.info("Method " + methodName + " returned: " + result);
        return "FAILED!";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
