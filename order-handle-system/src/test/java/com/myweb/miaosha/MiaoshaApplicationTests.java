package com.myweb.miaosha;

import com.myweb.miaosha.config.CommonConfig;
import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.entity.Good;
import com.myweb.miaosha.entity.Order;
import com.myweb.miaosha.entity.SecKillMsg;
import com.myweb.miaosha.rabbitmq.MQRecevier;
import com.myweb.miaosha.rabbitmq.MQSender;
import com.myweb.miaosha.service.CustomerService;
import com.myweb.miaosha.service.GoodService;
import com.myweb.miaosha.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
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

    @Autowired
    GoodService goodService;

    @Autowired
    OrderService orderService;

    @Autowired
    MQSender mqSender;

    @Autowired
    MQRecevier mqRecevier;

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

    //测试GoodService
    @Test
    void getGood(){
        Good g = goodService.getGood("car");
        System.out.println(g.getGoodName()+" "+g.getGoodTotalNum());
    }
    //测试OrderService
    @Test
    void getOrder(){
        Order order = orderService.getOrder(1,1);
        System.out.println(order.getOrderId());
    }
    //测试rabbitMQ
    @Test
    void sendOrder() throws Exception {
        SecKillMsg secKillMsg = new SecKillMsg(1,1);
        mqSender.sendSeckillMsg(secKillMsg);
    }
    @Test
    void receiveOrder() throws Exception {

    }
}
