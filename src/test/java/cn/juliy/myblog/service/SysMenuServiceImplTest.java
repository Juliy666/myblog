package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.SysMenuEntity;
import cn.juliy.myblog.mapper.SysMenuMapper;
import cn.juliy.myblog.utills.Constant;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuServiceImplTest extends ServiceImpl<SysMenuMapper,SysMenuEntity> {
    @Autowired
    private UserService userService;

/*    @Autowired
    private ShiroService shiroService;*/



    @Test
    public void getUserMenuList() {
        Long id=1L;
        //系统管理员的菜单列表，拥有最高权限
        if (id == Constant.SUPER_ADMIN){
            /*直接查出所有的菜单*/
            List<SysMenuEntity> entities = baseMapper.selectList(null);
            System.out.println(entities);
        }
    }


}
