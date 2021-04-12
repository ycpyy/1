package com.yc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class LogAspectCglib implements MethodInterceptor {
    private Object target;

    public LogAspectCglib(Object target){
        this.target=target;
    }

    public Object creatProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println("代理类的对象"+proxy.getClass());
//        System.out.println("目标类的方法"+method);
//        System.out.println("方法中的参数"+args);

        if(method.getName().startsWith("add")){
            //
            log();
        }
        Object returnValue=method.invoke(this.target,args);
        //
        return returnValue;
    }

    private void log(){
        System.out.println("==========before======");
        System.out.println("hello ,this is "+new Date());
        System.out.println("===========");
    }

}
