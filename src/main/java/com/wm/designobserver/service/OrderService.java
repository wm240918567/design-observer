package com.wm.designobserver.service;

import com.wm.designobserver.po.Orders;

/**
 * @author 王锰
 * @date 14:49 2019/7/5
 */
public interface OrderService {

    /**
     * 创建
     * @param orders
     */
    void create(Orders orders) throws InterruptedException;

}
