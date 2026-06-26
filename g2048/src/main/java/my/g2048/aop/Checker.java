package my.g2048.aop;

import lombok.extern.slf4j.Slf4j;
import my.g2048.model.Cell;
import my.g2048.model.Field;
import my.g2048.services.FieldService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class Checker {

    private boolean win = false;

    @Pointcut("execution(* my.sg2048.game.services.FieldService.move*())")
    public void test(){}

    @Around("test()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Field field = ((FieldService) joinPoint.getThis()).getField();
        win = field.getField().stream().flatMap(x -> x.getRow().stream()).map(Cell::getX).anyMatch(x -> x == 2048);
        if(win){
            return field;
        }
        return joinPoint.proceed();
    }

}
