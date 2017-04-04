package com.edutilos.main1;


import org.aspectj.lang.annotation.*;

@Aspect
public class PersonLogging {

    @Pointcut("execution(* com.edutilos.*.Person.* (..))")
   private void selectAll() {}


    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("Person: beforeAdvice");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("Person: afterAdvice");
    }

    @AfterReturning(value = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        if(retVal!= null) {
            System.out.println("Person: afterReturningAdvice = " + retVal.toString());
        } else {
            System.out.println("Person: afterReturningAdvice");
        }
    }

    @AfterThrowing(value = "selectAll()", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        if(ex!= null) {
            System.out.println("Person: afterThrowingAdvice = " + ex.getMessage());
        } else {
            System.out.println("Person: afterThrowingAdvice");
        }
    }
}
