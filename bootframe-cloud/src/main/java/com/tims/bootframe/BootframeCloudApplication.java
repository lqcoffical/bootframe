package com.tims.bootframe;

import com.tims.bootframe.cloud.demos.sentinel.SentinelWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SentinelWebConfig.class)
public class BootframeCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootframeCloudApplication.class, args);
    }

}
