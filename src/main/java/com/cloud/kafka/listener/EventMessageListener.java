package com.cloud.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author guokai
 * @create 2016-11-04 下午2:42
 **/

public class EventMessageListener {

    {
        System.out.println("监听器已经启动......");
    }
    @KafkaListener(topics = "event",group = "event-group")
    public void onMessage(String msg){
        System.out.println(System.currentTimeMillis() + "received message  " + msg);
    }




}
