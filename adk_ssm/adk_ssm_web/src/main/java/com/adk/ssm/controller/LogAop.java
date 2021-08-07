package com.adk.ssm.controller;


import com.adk.ssm.domain.SysLog;
import com.adk.ssm.service.LogAopService;
import com.adk.ssm.utils.UUIDutils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    //通过在web.xml文件中配置org.springframework.web.context.request.RequestContextListener 获得这个request对象

    private Date visitTime;
    private Class Clazz;
    private Method method;
    @Autowired
    private LogAopService logAopService;

    //前置通知  获取开始时间 执行类 执行方法
    @Before("execution(* com.adk.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime=new Date();
        //jp可以通过这个方法获取当前访问的类
        Clazz =jp.getTarget().getClass();

        //获取访问的方法名
        String methodName=jp.getSignature().getName();

        Object[] args = jp.getArgs();//获取参数 每一个参数都是一个对象

        if(args==null||args.length==0){
            method=Clazz.getMethod(methodName);
            //无参情况下直接可以通过方法名获取方法
        }else {
            Class[] classArgs = new Class[args.length];//新建一个类数组 将每一个参数填进去
            for(int i=0;i<args.length;i++){
                classArgs[i]=args[i].getClass();//每一个参数都被封装成一个类 并且填入进去.
            }
            method=Clazz.getMethod(methodName,classArgs);//填入方法名和参数类数组，获取到方法
        }

    }
    //后置通知
    @After("execution(* com.adk.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        String url = null;
        long time =new Date().getTime()-visitTime.getTime();//获取访问的时长
        //获取url
        if(Clazz!=null && method!=null && Clazz!=LogAop.class){
            //1、获取requestmapping的主路径 类上的注解
            RequestMapping classAnnotation= (RequestMapping) Clazz.getAnnotation(RequestMapping.class);

            if(classAnnotation!=null){
                String urlhead = classAnnotation.value()[0];

                //2、获取方法上的requestmapping
                RequestMapping methondAnnotation = method.getAnnotation(RequestMapping.class);
                if (methondAnnotation!=null){
                    String urlTail=methondAnnotation.value()[0];
                    url=urlhead+urlTail;

                    //获取ip地址
                    String ip=request.getRemoteAddr();

                    //获取操作者  通过springsecurity来获取
                    SecurityContext context= SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //封装到SysLog
                    SysLog sysLog = new SysLog();
                    sysLog.setIp(ip);
                    sysLog.setId(UUIDutils.getUUID());
                    sysLog.setExecutionTime(time);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    sysLog.setMethod("className: "+Clazz.getName()+" methodName: "+method.getName());
                    logAopService.save(sysLog);
                }
            }
        }

    }
}
