package cn.juliy.myblog;

import cn.juliy.myblog.entity.UserTokenEntity;
import cn.juliy.myblog.service.UserTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogApplicationTests {
    @Autowired
    private UserTokenService userTokenService;
    /*测试userTokenService生成token方法*/
    @Test
    public void createToken() {
        long i=1;
        UserTokenEntity token = userTokenService.createToken(i);
        System.out.println(token);
    }

}
