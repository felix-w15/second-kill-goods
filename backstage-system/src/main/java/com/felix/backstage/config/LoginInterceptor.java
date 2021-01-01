package com.felix.backstage.config;

import com.felix.backstage.entity.Admin;
import com.felix.backstage.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


public class LoginInterceptor implements HandlerInterceptor {
    private final LogService logService;


    public LoginInterceptor(LogService logService){
        super();
        this.logService = logService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Admin user = (Admin)session.getAttribute("user");
        if(user == null){
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("login").forward(request, response);
            return false;
        }
        System.out.println(logService == null);
        logService.insertLog(request.getRequestURL().toString(),new Date().toString(), user.getUsername());
        return true;
    }
}
