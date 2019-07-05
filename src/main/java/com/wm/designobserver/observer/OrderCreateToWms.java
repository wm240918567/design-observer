package com.wm.designobserver.observer;

import com.wm.designobserver.po.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 王锰
 * @date 15:20 2019/7/5
 */
@Component("toWms")
@Slf4j
public class OrderCreateToWms implements OrderCreateObserver {

    @Override
    public void accept(Orders orders) {
        log.info("创建成功--回WMS");
    }
}
