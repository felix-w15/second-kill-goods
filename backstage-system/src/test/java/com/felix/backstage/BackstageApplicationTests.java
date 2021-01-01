package com.felix.backstage;

import com.felix.backstage.entity.*;
import com.felix.backstage.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BackstageApplicationTests {
    @Autowired
    AdminService adminService;

    @Autowired
    NavigationService navigationService;

    @Autowired
    AdminGroupService adminGroupService;

    @Autowired
    CustomerService customerService;

    @Autowired
    GoodService goodService;

    @Autowired
    OrderService orderService;

    @Autowired
    LogService logService;

    @Test
    void contextLoads() {
    }


    @Test
    void getAdmin(){
        Admin a = adminService.getAdminByName("wx");
        System.out.println(a.getUsername()+" "+a.getGroupId());
    }
    @Test
    void getNavigation(){
        Navigation navigation = navigationService.getNavigationById(1);
        System.out.println(navigation.getNavName());
    }
    @Test
    void getAdminGroup(){
        AdminGroup adminGroup = adminGroupService.getAdminGroupById(1);
        System.out.println(adminGroup.getRules().split(",")[0]);
    }
    @Test
    void getMenuByPID(){
        List<Navigation> list = navigationService.getNavigationByPId(0);
        for(Navigation navigation: list)
            System.out.println(navigation.getNavName());
    }
    @Test
    void insertAdmin(){
        customerService.insertCustomer("wx1","123");
    }
    @Test
    void getAllCus(){
        List<Customer> list = customerService.getAllCustomer();
        for(Customer customer: list)
            System.out.println(customer.getUsername());
    }
    @Test
    void delCus(){
        customerService.delCustomer("wx");
    }
    @Test
    void editCus(){
        customerService.editCustomer("wx","12");
    }
    @Test
    void getGood(){
        Good good =  goodService.getGoodByName("car");
        System.out.println(good.getGoodName());
    }
    @Test
    void insertGood(){
        goodService.insertGood("car2",1000);
    }
    @Test
    void getALlGood(){
        List<Good> list = goodService.findAllGood();
        for(Good good:list)
            System.out.println(good.getGoodName());
    }
    @Test
    void delGood(){
        goodService.delGood("car2");
    }
    @Test
    void getAllOrder(){
        List<Order> list = orderService.getAllOrder();
        for(Order order: list)
            System.out.println(order.getCustomer_id());
    }
    @Test
    void getCusById(){
        Customer customer = customerService.getCustomerById(1);
        System.out.println(customer.getUsername());
    }
    @Test
    void getGoodById(){
        Good good = goodService.getGoodById(1);
        System.out.println(good.getGoodName());
    }
    @Test
    void getAllLog(){
        List<Log> list = logService.getAllLog();
        for(Log log:list)
            System.out.println(log.getUrl());
    }
    @Test
    void insertLog(){
        logService.insertLog("/login", "2021-1-1","wx");
    }
    @Test
    void time(){
        Date d = new Date();
        System.out.println(d.toString());
    }
}
