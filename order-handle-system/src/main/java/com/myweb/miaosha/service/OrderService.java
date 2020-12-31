package com.myweb.miaosha.service;

import com.myweb.miaosha.entity.Order;
import com.myweb.miaosha.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order getOrder(int customerId, int goodId){
        return orderMapper.getOrder(customerId, goodId);
    }

    public void putOrder(int customerId, int goodId){
        orderMapper.putOrder(customerId, goodId);
    }
}
