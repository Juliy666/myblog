package cn.juliy.myblog.controller;


import cn.juliy.myblog.service.SysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 系统菜单
 * @Return
 * @param
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuController extends AbstractController{
    @Autowired
    private SysMenuService sysMenuService;

/*    @Autowired
    private ShiroService shiroService;*/

    /**
     * @Description 导航菜单
     * @Return
     * @param
     **/
    @Test
    public void nav(){
        /*List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());*/

        /*Set<String> permissions = shiroService.getUserPermissions(getUserId());*/

    }
}
