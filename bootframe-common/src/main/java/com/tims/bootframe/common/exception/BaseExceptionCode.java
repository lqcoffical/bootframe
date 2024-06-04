package com.tims.bootframe.common.exception;

import lombok.Getter;

@Getter
public enum BaseExceptionCode implements ExceptionCode {

    FAIL(-1, "服务器繁忙,请稍后再试！"),

    SUCCESS(0, "success"),
    SUCCESS_TEMP(200, "success"),

    FLOW_CONTROL(429, "too many requests"),

    CODE_NOT_BE_EMPTY(2000, "CODE不能为空"),
    NOT_EXIST_SERVICE(2050, "不存在的SERVICE"),

    EXPIRED_TICKET(10101, "ticket失效,请重新登录"),
    USER_NO_LOGIN(10102, "未登录,请重新登录"),
    INTERNAL_ERROR(10103, "网络异常"),
    CATCH_EXCEPTION(10104, "API接口异常，请稍后再试"),
    SIGN_ERROR(10105, "验签错误"),
    PARAMETER_TYPE_ERROR(10106, "参数类型错误"),
    PARAMETER_ERROR(10107, "输入参数错误"),
    PARAMETER_LAKE(10108, "缺少必填参数"),
    REQUEST_ERROR(10109, "请求错误"),
    REQUEST_TIMEOUT(10110, "请求超时"),
    NO_PERMISSION(10111, "您无权限操作"),
    FREQUENCY_ERROR(10112, "您提交过于频繁"),
    USER_NO_AUTHORITY_ERROR(10113, "您不是团长,无访问权限"),
    USER_AUTHORIZE_DECRYPT_ERROR(10114, "微信用户信息解析失败"),
    DB_ERROR_NO_TUAN_LEADER(10115, "无团长信息"),
    API_ERROR_GET_MESSAGE_ERROR(10116, "消息获取失败"),
    API_TRADE_CENTER_GET_ORDER_ERROR(10117, "订单信息获取失败"),
    API_TRADE_CENTER_GET_ORDER_LIST_ERROR(10118, "订单数量信息获取失败"),
    EMPTY_FILE(10119, "上传文件为空"),
    GEN_FILE_ERROR(10120, "临时文件生成失败"),
    TASK_USER_ERROR(10121, "用户未参加任务"),
    TASK_USER_UNFINISHED_ERROR(10122, "用户尚未完成任务"),
    LEADER_STATE_ERROR(10123, "您所在团点的团长已被关店，现在无法登录，请联系您的团长了解情况。"),

    SERVER_501_ERROR(10501, "连接501"),
    CLIENT_ABORT_ERROR(10601, "请求超时"),

    QCODE_FAIL(10701,"二维码生成失败"),

    GET_GOODS_FAIL(10801,"获取商品失败"),
    STATUS_ERROR(10802, "支付单状态错误"),
    SHOP_PAY_NOT_EXIST(10803, "待支付单不存在"),
    SHOP_PAY_CONTRACT_TYPE_ERROR(10903, "桔契合同类型错误"),

    GROUP_LEADER_UPLOAD_ERROR(20004, "上传图片失败"),

    FILE_PIC_SIZE_ERROR(40001, "图片过大，请限制在5M内"),
    FILE_PIC_GIF_ERROR(40002, "图片不可为gif图"),

    SWITCH_DATABASE_ERROR(90000001, "3点到6点系统升级,请稍后"),
    SYSTEM_METHOD_POLLY_ERROR(100300001, "接口熔断"),

    DATE_TO_LONG(400300001, "查询日期过大")
    ;


    private Integer errno;
    private String errMessage;

    BaseExceptionCode(int code, String errMessage) {
        this.errno = code;
        this.errMessage = errMessage;
    }

}
