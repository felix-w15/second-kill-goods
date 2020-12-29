package com.myweb.miaosha;

import com.myweb.miaosha.config.CommonConfig;
import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MiaoshaApplicationTests {

    @Autowired
    CustomerService customerService;

    @Autowired
    CommonConfig commonConfig;

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

    @Test
    void getProperties() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        date = formatter.parse(commonConfig.getStartTimeStr());
        System.out.println(date.toString());
        date = formatter.parse(commonConfig.getEndTimeStr());

        System.out.println(new Date().toString());
    }
}
