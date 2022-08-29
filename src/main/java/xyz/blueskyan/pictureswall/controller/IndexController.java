package xyz.blueskyan.pictureswall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.blueskyan.pictureswall.entity.Picinfo;
import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.service.PicinfoService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PicinfoService picinfoService;


    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex(HttpSession session, Model model) {
        User user = (User) session.getAttribute("LoginUser");
        QueryWrapper<Picinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleid", user.getRoleid());
        List<Picinfo> list = picinfoService.list(queryWrapper);
        model.addAttribute("list", list);
        return "index";

    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }
}
