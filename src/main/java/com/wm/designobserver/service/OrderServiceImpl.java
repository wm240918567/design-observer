package com.wm.designobserver.service;

import com.wm.designobserver.subject.OrderCreateSubject;
import com.wm.designobserver.po.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王锰
 * @date 14:50 2019/7/5
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderCreateSubject orderCreateSubject;

    @Override
    public void create(Orders orders) throws InterruptedException {
        log.info("进入创建处理");
        Thread.sleep(1000L);
        log.info("订单创建处理结束，通知下游三方系统");
        orderCreateSubject.notify(orders);

    }
}
