package com.myweb.miaosha.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.myweb.miaosha.config.CommonConfig;
import com.myweb.miaosha.entity.Customer;
import com.myweb.miaosha.entity.SecKillRes;
import com.myweb.miaosha.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebController {


    @Autowired
    CustomerService customerService;

    @Autowired
    private DefaultKaptcha kaptchaProducer;

    @Autowired
    CommonConfig commonConfig;

    @GetMapping({"", "/login"})
    public String login(HttpSession session) {
        if (session.getAttribute("user") != null) return "index";
        return "login";
    }

    @PostMapping({"/doLogin"})
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                          HttpSession session, Model model) {
        model.addAttribute("carNums", 1000);
        if (session.getAttribute("user") != null) {
            Customer c = (Customer) session.getAttribute("user");
            System.out.println(c.getUsername());
            return "index";
        }
        Customer customer = customerService.getCustomer(username);
        if (customer == null || !customer.getPassword().equals(password)) {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
        session.setAttribute("user", customer);
        System.out.println("---------" + customer.getUsername() + " login---------");
        return "index";
    }

    @RequestMapping("/loginValidateCode")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaOutputStream = null;
        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        System.out.println("验证码更新");
        try {
            //生产验证码字符串并保存到session中
            String verifyCode = kaptchaProducer.createText();
            httpServletRequest.getSession().setAttribute("verifyCode", verifyCode);
            BufferedImage challenge = kaptchaProducer.createImage(verifyCode);
            ImageIO.write(challenge, "jpg", imgOutputStream);

        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        captchaOutputStream = imgOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaOutputStream);
        try {
            responseOutputStream.flush();
        } finally {
            responseOutputStream.close();
        }
    }

    @RequestMapping("/getCarNum")
    @ResponseBody
    public Object getCarNum() {
        return 999;
    }


    @GetMapping("/logout")
    @ResponseBody
    public void logout(HttpSession session) {
        session.setAttribute("user", null);
    }

    @GetMapping("getURL")
    @ResponseBody
    public String getURL() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart, dateEnd;
        dateStart = formatter.parse(commonConfig.getStartTimeStr());
        dateEnd = formatter.parse(commonConfig.getEndTimeStr());
        Date nowTime = new Date();
//        System.out.println(nowTime.getTime()+" "+ dateStart.getTime());
        if(nowTime.getTime() < dateStart.getTime() || nowTime.getTime() >= dateEnd.getTime()){
            return "";
        }
//        System.out.println("获取url");

        return "/secKill";
    }

    @PostMapping("/secKill")
    @ResponseBody
    public SecKillRes secKill(@RequestParam("myValidateCode") String myValCode, HttpSession session) {
        //判断验证码是否正确
        String valCode = (String) session.getAttribute("verifyCode");
        SecKillRes res = new SecKillRes();
//        System.out.println(valCode+" "+myValCode);
        if (!valCode.equals(myValCode)) {
            res.setCode(300);
            res.setStatus("验证码错误");
            return res;
        }
        res.setCode(200);
        res.setStatus("请求提交成功");
        return res;
    }
}
