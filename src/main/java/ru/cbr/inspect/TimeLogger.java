package ru.cbr.inspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TimeLogger {

    @Pointcut("@annotation(ExecutionTime) && within(ru.cbr.*)")
    public void checkExecutionTime() {
    }

    @Around("checkExecutionTime()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long initTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis()-initTime;
        long maxTime = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(ExecutionTime.class).max();
        if(executionTime > maxTime) {
            String methodName = joinPoint.getSignature().toString();
            System.out.printf("Execution time %6d ms (> %d):   %s%n", executionTime, maxTime, methodName);
        }
        return proceed;
    }
}
