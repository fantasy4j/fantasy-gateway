package com.fantasy4j.gateway.exception;

/**
 * Created by lihui23 on 2019/11/25
 */
public class GatewayRuntimeException  extends RuntimeException {

    public GatewayRuntimeException(String message){
        super(message);
    }

    public GatewayRuntimeException(String messaeg,Throwable cause){
        super(messaeg,cause);
    }


}
