package com.tims.bootframe.biz.listener;

import com.tims.bootframe.biz.event.DemoEvent;
import com.tims.bootframe.biz.event.DemoEventArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 1. 定义事件DemoEvent
 * 2. DemoEventListener这里写监听后的处理逻辑，方法入参是自定义的时间类
 * 3. ApplicationEventPublisher发布事件，这个可以是我们的一个业务类@Service中的一个动作
 *  直接注入ApplicationEventPublisher就可以
 */
@Component
public class DemoPublisher {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    /**
     * 监听springboot启动事件，为了方便测试
     */
    @EventListener(ApplicationReadyEvent.class)
    public void publishEvent(){
        DemoEventArgs eventArgs = DemoEventArgs.builder()
                .id(123)
                .username("用户1")
                .build();
        DemoEvent demoEvent = new DemoEvent(eventArgs,"ok");
        // 默认是主线程去做的，这里可以结合异步去处理，在listener里边写异步逻辑
        System.out.println(Thread.currentThread().getName());
        // 这个publisher调用publishEvent方法
        applicationEventPublisher.publishEvent(demoEvent);
    }

}
