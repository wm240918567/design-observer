package com.wm.designobserver.observer;

import com.wm.designobserver.po.Orders;

/**
 * 订单创建的订阅者
 * @author 王锰
 * @date 15:07 2019/7/5
 */
public interface OrderCreateObserver {

    /**
     * 执行
     * @param orders
     */
    void accept(Orders orders);

}
