package cn.kotori.springboot.controller;

import cn.kotori.springboot.common.ServerResponse;
import cn.kotori.springboot.custom.AllException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AllControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ServerResponse errorHandler(Exception ex) {
        log.info("异常捕捉{}",ex.getMessage());
        return ServerResponse.createByErrorMessage(ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 AllException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AllException.class)
    public ServerResponse myErrorHandler(AllException ex) {
        log.info("异常捕捉{}",ex.getMsg());
        return ServerResponse.createByErrorCodeMessage(ex.getCode(),ex.getMsg());
    }
}
