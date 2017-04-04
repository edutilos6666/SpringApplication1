package com.edutilos.main1;


import com.sun.org.apache.xpath.internal.SourceTree;
import org.aspectj.lang.annotation.*;

@Aspect
public class WorkerLogging {
    @Pointcut("execution(* com.edutilos.*.Worker.* (..))")
    private void selectAll() {}


    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("before Advcie");
    }

    @After("selectAll()")
    public void afterAdvic() {
        System.out.println("after Advice");
    }

    @AfterReturning(pointcut = "selectAll()" , returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.print("afterReturniing Advice = ");
        if(retVal != null)
            System.out.println( retVal.toString());
        else
            System.out.println();
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.print("afterThrowingAdvice = ");
        if(ex != null)
            System.out.println(ex.getMessage());
        else
            System.out.println();
    }
}
