package com.wm.designobserver.subject;

import com.wm.designobserver.observer.OrderCreateObserver;
import com.wm.designobserver.po.Orders;

/**
 * 订单创建主题
 * @author 王锰
 * @date 14:27 2019/7/5
 */
public interface OrderCreateSubject {

    /**
     * 订阅
     * @param orderObserver
     */
    boolean register(OrderCreateObserver orderObserver);

    /**
     * 取消订阅
     * @param orderObserver
     */
    void remove(OrderCreateObserver orderObserver);

    /**
     * 推送订阅内容
     */
    void notify(Orders orders);

}
