package com.myweb.miaosha;

import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiaoshaApplicationTests {

    @Autowired
    CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    void getCustomer(){
        String username = "wuxin";
        Customer c = customerService.getCustomer(username);
        if(c != null)
            System.out.println(c.getId()+" "+c.getUsername()+" "+c.getPassword());
        else System.out.println("NULL");
    }

}
