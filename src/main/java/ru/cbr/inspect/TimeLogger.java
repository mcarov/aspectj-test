package ru.cbr.inspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class TimeLogger {
    @Pointcut("@annotation(time) && execution(* *(..))")
    public void checkExecutionTime(ExecutionTime time) {
    }

    @Around("checkExecutionTime(time)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, ExecutionTime time) throws Throwable {
        long initTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis()-initTime;
        if(executionTime > time.max()) {
            String methodSignature = joinPoint.getSignature().toString();
            System.out.printf("Execution time %6d ms (> %d):   %s%n", executionTime, time.max(), methodSignature);
        }

        return proceed;
    }
}
