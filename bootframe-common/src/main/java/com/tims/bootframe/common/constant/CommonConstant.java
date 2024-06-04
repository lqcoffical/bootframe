package com.tims.bootframe.common.constant;

/**
 * 常量类定义常量，在编码中不出现魔法值
 * 常量类不定义在接口中：from Effective Java
 * final修饰，私有化构造方法
 * 变量public static final修饰
 * 其他类使用时只引入常量不引入类：import static CommonConstant.DEFAULT_SUCCESS_ERRNO;
 */
public final class CommonConstant {

    private CommonConstant() {
    }

    public static final Integer DEFAULT_SUCCESS_ERRNO = 0;

    public static final Integer DEFAULT_SUCCESS_STATUS = 200;

    public static final Integer DEFAULT_FAIL_ERRNO = 10000;

    public static final Integer DEFAULT_FAIL_STATUS = 500;

    public static final String DEFAULT_SUCCESS_MESSAGE = "success";

    public static final String DEFAULT_FAIL_MESSAGE = "fail";

}
