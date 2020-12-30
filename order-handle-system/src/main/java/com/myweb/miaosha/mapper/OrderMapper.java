package com.myweb.miaosha.mapper;

import com.myweb.miaosha.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order getOrder(int customerId, int goodId);
}
