package com.tims.bootframe.common.front;

import com.tims.bootframe.common.constant.CommonConstant;
import com.tims.bootframe.common.exception.BaseExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -1382378592206497112L;

    private Integer errNo;

    private String errMessage;

    /**
     * traceId有个默认值，应该是从上下文里拿
     */
    //private String traceId;

    private T data;

    @Builder.Default
    private static Integer SUCCESS_ERR_NO = CommonConstant.DEFAULT_SUCCESS_ERRNO;

    @Builder.Default
    private static String SUCCESS_ERR_MSG = CommonConstant.DEFAULT_SUCCESS_MESSAGE;

    /**
     * 提供一个默认成功的方法调用，使用者代码写的越少越好。这里new 不用builder，因为还要强转
     *
     * @param data
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(SUCCESS_ERR_NO, SUCCESS_ERR_MSG, data);
    }

    /**
     * 默认失败的返回方法
     *
     * @return
     */
    public static <T> BaseResponse<T> fail() {
        return new BaseResponse<>(BaseExceptionCode.CATCH_EXCEPTION.getErrno(),
                BaseExceptionCode.CATCH_EXCEPTION.getErrMessage(),
                null);
    }

}
