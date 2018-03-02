package cn.kotori.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {


    @Value("${home.desc}")
    private String desc;

    @RequestMapping("/")
    public String sayHello() {
        log.info("v1.0开始");
        return desc;
    }
}
