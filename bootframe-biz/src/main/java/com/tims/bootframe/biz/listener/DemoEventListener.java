package com.tims.bootframe.biz.listener;

import com.tims.bootframe.biz.event.DemoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DemoEventListener {

    /**
     * @EventListener注解的condition，可以写spl表达式：成立才执行，不成立不执行
     * @param event
     */
    @EventListener(classes = DemoEvent.class, condition = "#event.message=='ok'")
    @Async
    public void listenAndHandleEventOk(DemoEvent event){
        // 这里写监听后的处理逻辑，方法入参是自定义的时间类
        System.out.println("事件是成功的");
        System.out.println("监听到了DemoEvent"+event.toString());
        System.out.println(Thread.currentThread().getName());
    }

    @EventListener(classes = DemoEvent.class, condition = "#event.message=='error'")
    @Async
    public void listenAndHandleEventError(DemoEvent event){
        // 这里写监听后的处理逻辑，方法入参是自定义的时间类
        System.out.println("事件是失败的");
        System.out.println("监听到了DemoEvent"+event.toString());
        System.out.println(Thread.currentThread().getName());
    }

}
