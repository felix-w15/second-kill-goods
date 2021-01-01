package com.felix.backstage.controller;

import com.felix.backstage.entity.*;
import com.felix.backstage.service.AdminGroupService;
import com.felix.backstage.service.AdminService;
import com.felix.backstage.service.CustomerService;
import com.felix.backstage.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class WebController {
    @Autowired
    AdminService adminService;

    @Autowired
    NavigationService navigationService;

    @Autowired
    AdminGroupService adminGroupService;

    @Autowired
    CustomerService customerService;

    @RequestMapping({"", "/login"})
    public String loginPage(HttpSession session) {
        if(session.getAttribute("user") != null){
            return "index";
        }
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                          HttpSession session, Model model){
        if(session.getAttribute("user") == null){
            Admin user = adminService.getAdminByName(username);
            if(user == null){
                model.addAttribute("msg","用户名或密码错误");
                return "login";
            } else {


                AdminGroup adminGroup = adminGroupService.getAdminGroupById(user.getGroupId());
                String[] menuIdStr = adminGroup.getRules().split(",");
                //本用户菜单id
                Set<Integer> menuId = new HashSet<>();
                List<NavigationTree> resTree = new ArrayList<>();
                for(int i = 0; i < menuIdStr.length; i++) {
                    int id = Integer.parseInt(menuIdStr[i]);
                    menuId.add(id);
                    Navigation temp = navigationService.getNavigationById(id);
                    if(temp.getParentId() == 0){
                        NavigationTree tempTree = new NavigationTree(temp);
                        resTree.add(tempTree);
                    }
                }
                for(NavigationTree navigationTree: resTree){
                    Navigation temp = navigationTree.getMynav();
                    List<Navigation> navigationList = navigationService.getNavigationByPId(temp.getNavId());
                    for(Navigation navigation: navigationList){
                        if(menuId.contains(navigation.getNavId())){
                            navigationTree.getChildren().add(new NavigationTree(navigation));
                        }
                    }
                }
                for(NavigationTree navigationTree: resTree)
                    System.out.println(navigationTree.getMynav().getNavName());
                session.setAttribute("user", user);
                session.setAttribute("menu", resTree);
            }
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("user", null);
        session.setAttribute("menu", null);
        return "login";
    }

    //访问修改密码页面
    @RequestMapping(value = "/pwdChangePage")
    public String pwdChange() {
        return "member-password";
    }

    @PostMapping(value = "/pwdChange")
    @ResponseBody
    public Response pwdChange(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass,
                            Model model, HttpSession session) {
        Admin user = (Admin)session.getAttribute("user");
        Response res = new Response();
        System.out.println(newpass+" "+oldpass);
        if(!oldpass.equals(user.getPassword())) {
            res.setCode(300);
            res.setStatus("密码错误");
        } else {
            res.setCode(200);
            res.setStatus("修改成功");
            adminService.updateAdmin(user.getUsername(), newpass);
        }
        return res;
    }

    @GetMapping("/addUserPage")
    public String addCustomer(){
        return "customer-add";
    }

    @GetMapping("/userPage")
    public String customerPage(Model model){
        List<Customer> customerList = customerService.getAllCustomer();
        model.addAttribute("customerNum", customerList.size());
        model.addAttribute("customers", customerList);
        return "customer-list";
    }



    @PostMapping("/addUser")
    @ResponseBody
    public Response addUser(@RequestParam("username") String username, @RequestParam("password") String password){
        customerService.insertCustomer(username, password);
        Response response = new Response(200,"成功插入用户");
        return response;
    }
    @PostMapping("/delUser")
    @ResponseBody
    public Response delUser(@RequestParam("username") String username){
        customerService.delCustomer(username);
        Response response = new Response(200,"成功删除");
        return response;
    }
    @PostMapping("/editUserPage")
    public String editUserPage(Model model, @RequestParam("username") String username, @RequestParam("password") String password){
        model.addAttribute("customerName", username);
        model.addAttribute("customerPassword", password);
        System.out.println(username);
        return "customer-edit";
    }
    @PostMapping("/editUser")
    public String editUser(Model model, @RequestParam("username") String username, @RequestParam("password") String password){
        customerService.editCustomer(username, password);
        List<Customer> customerList = customerService.getAllCustomer();
        model.addAttribute("customerNum", customerList.size());
        model.addAttribute("customers", customerList);
        return "customer-list";
    }

    @GetMapping("/addGoodPage")

}
