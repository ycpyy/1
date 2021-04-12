package com.yc;

import java.lang.reflect.*;
import java.util.Date;

public class LogAspect implements InvocationHandler{
    private Object target;

    public LogAspect(Object target){this.target=target; }

    public Object creatProxy(){
        //
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }




    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类的对象"+proxy.getClass());
        System.out.println("目标类的方法"+method);
        System.out.println("方法中的参数"+args);

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
