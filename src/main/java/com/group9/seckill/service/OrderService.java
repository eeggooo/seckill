package com.group9.seckill.service;

import com.group9.seckill.entity.OrderInfo;
import com.group9.seckill.entity.UserInfo;

import java.util.List;

public interface OrderService {
    void reduceStock(int miaoshaGoodsId);
    void insertOrder(OrderInfo orderInfo);
    OrderInfo updateOrderInfo(OrderInfo orderInfo);
    OrderInfo doOrderInfo(int miaoshaGoodsId, UserInfo userInfo);
    List<OrderInfo> selectOrder(UserInfo userInfo);
}
