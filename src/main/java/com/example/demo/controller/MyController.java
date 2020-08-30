package com.example.demo.controller;

import com.example.demo.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yq
 * @date: 2020/8/31 0:12
 * @description 测试Controller
 */
@Slf4j
@RestController
@RequestMapping("demo")
public class MyController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("test")
    public String test() {
        System.out.println("===========开始测试===========");
        System.out.println("开始发布事件");
        applicationContext.publishEvent(new MyEvent(this,"奔驰"));
        System.out.println("结束发布事件");
        System.out.println("===========结束测试===========");
        return "Success";
    }

    @Async //异步处理的注解
    @EventListener
    public void accept(MyEvent event){
        System.out.println("开始监听事件");
        String brands = event.getBrands();
        System.out.println("获取事件结果 ".concat(brands));
        //这里睡眠4s 是为了验证主线程不会阻塞
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束监听事件");
    }
}
