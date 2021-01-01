package com.felix.backstage.mapper;

import com.felix.backstage.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void insertCustomer(String username, String password);
    void delCustomer(String username);
    void editCustomer(String username, String password);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomer();
}
