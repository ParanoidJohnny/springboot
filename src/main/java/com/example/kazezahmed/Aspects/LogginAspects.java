package com.example.kazezahmed.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogginAspects {



// first * is for return type, before first * is for public or private method type
   @AfterReturning("execution(void com.example.kazezahmed.Controllers.ExamenController.get*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        log.info("Fin execution  : " + name );
    }

   /*

    # display message before execution of every method with name that starts with "ajouter" in "controllers"
    @Before("execution(* tn.esprit.controllers.*.ajouter*(..))")

    # display message after execution of every method of "services"
	@After("execution(* tn.esprit.services.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().getName();

		log.info("Out of method :" + name );
	}

    */
}
