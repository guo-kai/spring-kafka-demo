package com.cloud.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IDEA
 * Date: 2016/9/28
 * Time: 11:56
 * @author guokai
 * @version v1.0
 */
@Controller
public class IndexController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    /**
     * 初始页
     * @param model model
     * @return 返回首页
     */
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String index(Model model) {

        String msg = "hello Word!";

        kafkaTemplate.send("event",msg);
        System.out.println(System.currentTimeMillis() + "send message " + msg);
        return "success";
    }

}