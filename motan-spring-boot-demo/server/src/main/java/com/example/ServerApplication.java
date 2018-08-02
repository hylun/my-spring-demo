package com.example;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"${motan.xml:classpath*:motan*.xml}"})
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        // 在使用注册中心时要主动调用下面代码
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("server start...");
    }

    /*public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("classpath:motan_server.xml");
        System.out.println("server start...");
    }*/
}
