package com.wm.designobserver.controller;

import com.wm.designobserver.observer.OrderCreateObserver;
import com.wm.designobserver.subject.OrderCreateSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 王锰
 * @date 15:38 2019/7/5
 */
@RestController
@RequestMapping("/ob/order")
public class ObserverController {

    @Autowired
    private Map<String,OrderCreateObserver> observerMap;

    @Autowired
    private OrderCreateSubject subject;

    @GetMapping("/register/{type}")
    public boolean register(@PathVariable("type")String type){
        OrderCreateObserver observer = Optional.ofNullable(observerMap.get(type)).orElseThrow(() ->
                new RuntimeException("未定义的订阅者"));
        return subject.register(observer);
    }

    @GetMapping("/remove/{type}")
    public boolean remove(@PathVariable("type")String type){
        OrderCreateObserver observer = Optional.ofNullable(observerMap.get(type)).orElseThrow(() -> new RuntimeException("未定义的订阅者"));
        subject.remove(observer);
        return true;
    }

}
