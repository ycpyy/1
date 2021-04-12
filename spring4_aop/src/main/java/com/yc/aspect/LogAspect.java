package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Order(value = 100)
public class LogAspect {

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("************compute进到  增强了...");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end=System.currentTimeMillis();
        System.out.println("compute2 要退出增强了...");
        System.out.println("**********这个方法运行时间为:"+(end-start));
        return retVal;
    }


    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void add(){
        
    }
    
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void update(){

    }
    
    @Pointcut("add() || update()")
    private void addAndUpdate(){
        
    }



    //添加的声明
    @Before("com.yc.aspect.LogAspect.addAndUpdate()")
    public void log(){
        System.out.println("=========前置增强的日志==========");
        Date d =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr=sdf.format(d);
        System.out.println("执行时间:"+dstr);
        System.out.println("=========前置增强的日志结束=========");
    }
}
