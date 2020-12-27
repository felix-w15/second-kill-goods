package com.myweb.miaosha.controller;

import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }
    @PostMapping(value = "/doLogin")
    @ResponseBody
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                          HttpSession session, Model model){
        Customer customer = customerService.getCustomer(username);

        return "";
    }
}
