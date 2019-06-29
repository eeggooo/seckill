package com.group9.seckill.service.Impl;

import com.group9.seckill.dao.AddressDao;
import com.group9.seckill.dao.GoodsDao;
import com.group9.seckill.dao.OrderDao;
import com.group9.seckill.entity.*;
import com.group9.seckill.service.OrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    AddressDao addressDao;
    @Override
    public void reduceStock(int miaoshaGoodsId) {
        goodsDao.reduceStock(miaoshaGoodsId);
    }

    @Override
    public void insertOrder(OrderInfo orderInfo) {
        orderDao.insertOrder(orderInfo);
    }

    @Override
    @Transactional
    public OrderInfo updateOrderInfo(OrderInfo orderInfo) {

        orderInfo.setPay_time(new Date());
        orderDao.updateOrder(orderInfo);

        return orderInfo;
    }

    @Override
    public OrderInfo doOrderInfo(int miaoshaGoodsId, UserInfo userInfo) {
        reduceStock(miaoshaGoodsId);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrder_no(new Date().getTime()+String.valueOf(miaoshaGoodsId));
        MiaoShaGoods miaoShaGoods=goodsDao.selectMiaoShaGoodsByMiaoShaGoodsId(miaoshaGoodsId);
        orderInfo.setMiaoShaGoods(miaoShaGoods);
        orderInfo.setUserInfo(userInfo);
        orderInfo.setBuy_count(1);
        insertOrder(orderInfo);

        return  orderInfo;
    }

    @Override
    public List<OrderInfo> selectOrder(UserInfo userInfo) {
        return orderDao.selectOrder(userInfo);
    }
}
