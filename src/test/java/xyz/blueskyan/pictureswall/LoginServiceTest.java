package xyz.blueskyan.pictureswall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.blueskyan.pictureswall.entity.User;
import xyz.blueskyan.pictureswall.service.AdminService;

@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void loginTest(){
        User user = adminService.login("tom","123");
        System.out.println(user);
    }
}
