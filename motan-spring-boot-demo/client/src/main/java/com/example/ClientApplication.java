package com.example;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ImportResource(locations={"${motan.xml:classpath*:motan*.xml}"})
public class ClientApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(ClientApplication.class, args);
        // 在使用注册中心时要主动调用下面代码
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("client start...");
    }

    @Autowired
    private DemoService service;

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name){
        DemoService service1 = (DemoService) context.getBean("demoService");
        HelloService service2 = (HelloService) context.getBean("helloService");
        return service.hello(name)+"-------"+helloService.hello(name);
    }

}
