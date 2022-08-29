package xyz.blueskyan.pictureswall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.service.AdminService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登陆
     * @param username
     * @param password
     * @param session
     * @return map
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        User user = adminService.login(username, password);
        if (user != null) {
            session.setAttribute("LoginUser", user);
            map.put("code",1);
            map.put("msg","登录成功！");
        }else {
            map.put("code",0);
            map.put("msg","用户名或密码错误！");
        }
        return map;
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public Map<String,Object> register(String username,String password){
        Map<String,Object> map = new HashMap<>();
        if (adminService.register(username,password)){
            map.put("code",1);
            map.put("msg","注册成功！");
        }else {
            map.put("code",0);
            map.put("msg","用户名已存在！");
        }
        return map;
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "exit")
    @ResponseBody
    public String exit(HttpSession session){
        session.invalidate();
        return "1";
    }
}
