package com.roxi.vote.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Roxi酱
 */
@Slf4j
@Component
@Aspect
public class Aspects {
    @Pointcut("execution(public * com.roxi.vote.controller.MyController.*(..))")
    public void cut(){
    }
    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        HttpServletResponse response=servletRequestAttributes.getResponse();
        HttpSession session=request.getSession();
        String openId= (String) session.getAttribute("user");
        if(null!=openId) {
            log.info("openId:"+openId);
            System.out.println("openId:"+openId);
        }else {
            log.warn("没有授权登陆");
            System.out.println("没有授权登陆");
            return "Vote.html";
        }
        return pjp.proceed();
    }
}
