package com.example.demo.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author: yq
 * @date: 2020/8/31 0:01
 * @description 自定义事件
 */
@Data
public class MyEvent extends ApplicationEvent {

    private String brands;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source,String brands) {
        super(source);
        this.brands=brands;

    }
}
