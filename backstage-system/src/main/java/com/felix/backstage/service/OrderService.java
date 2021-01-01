package com.felix.backstage.service;

import com.felix.backstage.entity.Order;
import com.felix.backstage.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> getAllOrder(){
        return orderMapper.getAllOrder();
    }
}
