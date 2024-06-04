package com.tims.bootframe.biz.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoEventArgs {

    /**
     * 定义一些事件参数，写在event类里面也可以，这里抽出来写，解耦
     */
    private Integer id;
    private String username;
    private String message;
    private LocalDateTime creatTime;
    private Map args;

}
