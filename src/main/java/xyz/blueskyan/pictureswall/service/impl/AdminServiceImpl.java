package xyz.blueskyan.pictureswall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.mapper.UserMapper;
import xyz.blueskyan.pictureswall.service.AdminService;

import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public boolean register(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            String roleid = UUID.randomUUID().toString().replace("-","");
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            user1.setRoleid(roleid);
            userMapper.insert(user1);
            return true;
        } else {
            return false;
        }
    }
}
