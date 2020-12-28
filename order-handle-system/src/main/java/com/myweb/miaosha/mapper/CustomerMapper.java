package com.myweb.miaosha.mapper;

import com.myweb.miaosha.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface CustomerMapper {
    Customer getCustomer(String username);
}
