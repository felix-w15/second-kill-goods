package com.felix.backstage.service;

import com.felix.backstage.entity.Customer;
import com.felix.backstage.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    public void insertCustomer(String username, String password){
        customerMapper.insertCustomer(username, password);
    }

    public void delCustomer(String username){
        customerMapper.delCustomer(username);
    }

    public void editCustomer(String username, String password){
        customerMapper.editCustomer(username, password);
    }

    public Customer getCustomerById(int id){
        return customerMapper.getCustomerById(id);
    }
    public List<Customer> getAllCustomer(){
        return  customerMapper.getAllCustomer();
    }
}
