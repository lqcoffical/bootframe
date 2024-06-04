package com.tims.bootframe.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// @ServletComponentScan注解才能扫描到webFilter注解
@ServletComponentScan
@SpringBootApplication
public class BootframeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootframeWebApplication.class, args);
    }

}
