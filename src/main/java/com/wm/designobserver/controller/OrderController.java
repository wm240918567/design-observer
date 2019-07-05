package com.wm.designobserver.controller;

import com.wm.designobserver.po.Orders;
import com.wm.designobserver.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王锰
 * @date 14:25 2019/7/5
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Boolean post(@RequestBody Orders orders) throws InterruptedException {
        orderService.create(orders);
        return true;
    }

}
