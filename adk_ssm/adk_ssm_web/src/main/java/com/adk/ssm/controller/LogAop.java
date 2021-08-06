package com.adk.ssm.controller;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private Date visitTime;
    private Class Class;
    private Method method;

    //前置通知  获取开始时间 执行类 执行方法
    @Before("execution(* com.adk.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime=new Date();
        //jp可以通过这个方法获取当前访问的类
        Class =jp.getTarget().getClass();

        //获取访问的方法名
        String methodName=jp.getSignature().getName();

        Object[] args = jp.getArgs();//获取参数 每一个参数都是一个对象

        if(args==null||args.length==0){
            method=Class.getMethod(methodName);
            //无参情况下直接可以通过方法名获取方法
        }else {
            Class[] classArgs = new Class[args.length];//新建一个类数组 将每一个参数填进去
            for(int i=0;i<args.length;i++){
                classArgs[i]=args[i].getClass();//每一个参数都被封装成一个类 并且填入进去.
            }
            method=Class.getMethod(methodName,classArgs);//填入方法名和参数类数组，获取到方法
        }

    }
    //后置通知
    @After("execution(* com.adk.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp){

    }
}
