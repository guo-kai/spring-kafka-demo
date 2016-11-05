package com.cloud.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guokai
 * @create 2016-11-04 下午2:35
 **/
@SpringBootApplication
public class KafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class,args);
    }
}
