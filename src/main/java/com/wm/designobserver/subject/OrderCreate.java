package com.wm.designobserver.subject;

import com.wm.designobserver.observer.OrderCreateObserver;
import com.wm.designobserver.po.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单创建三方订阅
 *
 * @author 王锰
 * @date 15:14 2019/7/5
 */
@Component
@Slf4j
public class OrderCreate implements OrderCreateSubject {

    //    @Autowired
    private List<OrderCreateObserver> obServerList;

    public OrderCreate() {
        this.obServerList = new ArrayList<>();
    }

    @Override
    public boolean register(OrderCreateObserver orderObserver) {
        for (OrderCreateObserver observer : obServerList) {
            if (observer.equals(orderObserver)){
                log.info("该主题已经订阅");
                return true;
            }
        }
        return obServerList.add(orderObserver);
    }

    @Override
    public void remove(OrderCreateObserver orderObserver) {
        obServerList.remove(orderObserver);
    }

    @Override
    public void notify(Orders orders) {
        obServerList.forEach(obServer -> {
            obServer.accept(orders);
        });
    }
}
