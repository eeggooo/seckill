package com.group9.seckill.dao;

import com.group9.seckill.entity.OrderInfo;
import com.group9.seckill.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {
    void insertOrder(OrderInfo orderInfo);
    void updateOrder(OrderInfo orderInfo);
    List<OrderInfo> selectOrder(UserInfo userInfo);
}
