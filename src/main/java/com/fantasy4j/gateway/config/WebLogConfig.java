package com.fantasy4j.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 请求日志记录
 * <p>
 * Created by lihui23 on 2019/11/25
 */
@Aspect
@Component
@Slf4j
public class WebLogConfig {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        log.info("URL : " + request.getRequestURL().toString() +
                ",HTTP_METHOD : " + request.getMethod() +
                ",IP : " + request.getRemoteAddr() +
                ",CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() +
                ",ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        log.info("RESPONSE : " + Arrays.toString(((PageImpl) ret).getContent().toArray()) +
                ",SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

}
