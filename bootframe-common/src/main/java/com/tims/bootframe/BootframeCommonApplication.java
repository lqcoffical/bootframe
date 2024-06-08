package com.tims.bootframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BootframeCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootframeCommonApplication.class, args);
    }

}
