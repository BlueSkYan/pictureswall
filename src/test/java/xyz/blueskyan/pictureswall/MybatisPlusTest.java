package xyz.blueskyan.pictureswall;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.blueskyan.pictureswall.entity.Picinfo;
import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.mapper.PicinfoMapper;
import xyz.blueskyan.pictureswall.mapper.UserMapper;
import xyz.blueskyan.pictureswall.service.PicinfoService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PicinfoMapper picinfoMapper;

    @Autowired
    private PicinfoService picinfoService;

    @Test
    public void testSelect(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public  void testInsert(){
        Picinfo picinfo = new Picinfo();
        Date date = new Date();
        picinfo.setDatetime(date);
        picinfoMapper.insert(picinfo);
    }

    @Test
    public void testUuid(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        System.out.println(uuid);
    }

    @Test
    public void testList(){
        QueryWrapper<Picinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleid","ed01ef0b87544a94aed19364017de5b8");
        List<Picinfo> list = picinfoService.list(queryWrapper);
        list.forEach(System.out::println);
    }
}
