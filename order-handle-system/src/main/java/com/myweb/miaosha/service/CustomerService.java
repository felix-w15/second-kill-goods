package com.myweb.miaosha.service;

import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    public Customer getCustomer(String username){
        return customerMapper.getCustomer(username);
    }
}
