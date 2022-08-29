package xyz.blueskyan.pictureswall.service.impl;

import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.mapper.UserMapper;
import xyz.blueskyan.pictureswall.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blueskyan
 * @since 2022-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
