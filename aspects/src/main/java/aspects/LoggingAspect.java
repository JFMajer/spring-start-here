package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method " + joinPoint.getSignature().getName() + " called at " + new Date() + "");
        joinPoint.proceed();
        logger.info("Method " + joinPoint.getSignature().getName() + " finished at " + new Date() + "");
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
