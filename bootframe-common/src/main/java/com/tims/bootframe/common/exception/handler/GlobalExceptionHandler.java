package com.tims.bootframe.common.exception.handler;

import com.tims.bootframe.common.exception.BaseExceptionCode;
import com.tims.bootframe.common.front.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理的异常可以再自定义系统异常类，然后细化异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public <T> BaseResponse<T> handleException(Exception e) {
        // todo:配置系统日志，用日志输出异常
        e.printStackTrace();
        return BaseResponse.fail();
    }
}
