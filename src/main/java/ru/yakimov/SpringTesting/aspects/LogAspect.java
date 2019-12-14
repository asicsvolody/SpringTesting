/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.SpringTesting.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.yakimov.SpringTesting.SpringTestingApplication;


@Aspect
@Component
public class LogAspect {
    private static Logger logger= LoggerFactory.getLogger(SpringTestingApplication.class);

    @Around("execution(* ru.yakimov.SpringTesting.tester.Test.ask(..))")
    public Object logQuestion(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Ask question");
        Object res = joinPoint.proceed();
        System.out.println("Answer is "+ res);
        return res;
    }

    @Before("execution(* ru.yakimov.SpringTesting.tester.Test.*(..))")
    public void logBefore(JoinPoint joinPoint){
        logger.info("Start "+ joinPoint.getSignature().getName());
    }
}
