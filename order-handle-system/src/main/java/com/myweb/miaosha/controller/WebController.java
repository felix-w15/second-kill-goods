package com.myweb.miaosha.controller;

import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.entity.LoginResponse;
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

    @GetMapping({"","/login"})
    public String login(HttpSession session) {
        if(session.getAttribute("user") != null) return "index";
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                                 HttpSession session, Model model) {
        if(session.getAttribute("user") != null) return "index";
        Customer customer = customerService.getCustomer(username);
        if (customer == null || !customer.getPassword().equals(password)) {
            model.addAttribute("msg", "用户名或密码错误");
            session.setAttribute("user", customer);
            return "login";
        }
        System.out.println("---------"+customer.getUsername()+" login---------");
        return "index";
    }
}
