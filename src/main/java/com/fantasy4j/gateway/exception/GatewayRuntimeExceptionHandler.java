package com.fantasy4j.gateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于异常数据收集
 * <p>
 * Created by lihui23 on 2019/11/25
 */
@ControllerAdvice
@Slf4j
public class GatewayRuntimeExceptionHandler {

    /**
     * 如果发生异常信息，统一对请求结果进行熔断处理，并对机场进行记录
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(GatewayRuntimeException.class)
    @ResponseBody
    public String handleGatewayRuntimeException(HttpServletRequest request, Exception ex) {
        log.info("request uri:" + request.getRequestURI() + ",request method:" + request.getMethod());
        //构造返回对象
        return ex.getMessage();
    }
}
