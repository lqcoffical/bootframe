package com.tims.bootframe.biz.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 事件类，要继承ApplicationEvent，重写构造方法
 * 一些属性也可以写在这个时间类中，属性抽出去写方便解耦
 */
@Getter
public class DemoEvent extends ApplicationEvent {

    // 属性要定义成message的，要不外部拿不到。或者用getter注解
    private String message;

    public DemoEvent(DemoEventArgs source, String message) {
        super(source);
        this.message=message;
    }

}
