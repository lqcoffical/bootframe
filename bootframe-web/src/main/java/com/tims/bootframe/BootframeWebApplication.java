package com.tims.bootframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

// @ServletComponentScan注解才能扫描到webFilter注解
@ServletComponentScan
@EnableAsync
@SpringBootApplication
public class BootframeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootframeWebApplication.class, args);
    }

}
