package com.study.springboot.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     *  定义一个公共的方法，实现复用
     *  拦截TestAopController下面的所有方法
     *  拦截TestAopController下面的userList方法里的任何参数(..表示拦截任何参数)写法：@Before("execution(public * com.study.controller.TestAopController.hello(..))")
     */
    @Pointcut("execution(public * com.study.springboot.controller.TestAopController.*(..))")
    public void log() {
        System.out.println("==========公用log方法===========");
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Map params = new HashMap();
        params.put("url", request.getRequestURL()); // 获取请求的url
        params.put("method", request.getMethod()); // 获取请求的方式
        params.put("ip", request.getRemoteAddr()); // 获取请求的ip地址
        params.put("className", joinPoint.getSignature().getDeclaringTypeName()); // 获取类名
        params.put("classMethod", joinPoint.getSignature().getName()); // 获取类方法
        params.put("args", joinPoint.getArgs()); // 请求参数
        // 输出格式化后的json字符串
        logger.error(JSON.toJSONString(params));

    }


    /**
     * 后置通知
     */
    @After("log()")
    public void doAfter(){
        logger.error("doAfter");
    }

    /**
     * 环绕通知
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        try {
            Object proceed = joinPoint.proceed();
            logger.error("doAround："+proceed);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {

        }
        return null;
    }

    /**
     * 返回后通知
     * @param o
     */
    @AfterReturning(value = "log()",returning = "o")
    public void afterReturn(Object o){
        logger.error("AfterReturning");
        System.out.println(o);
    }

    /**
     * 异常退出
     */
    @AfterThrowing("log()")
    public void afterRhroing(){
        logger.error("发生异常");
    }
}
