package com.tims.bootframe.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootframeBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootframeBizApplication.class, args);
    }

}
