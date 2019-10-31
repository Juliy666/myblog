package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.SysMenuEntity;
import cn.juliy.myblog.mapper.SysMenuMapper;
import cn.juliy.myblog.mapper.UserMapper;
import cn.juliy.myblog.utills.Constant;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroServiceImplTest {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void getUserPermissions() {
        Long id = 1L;
        List<String> permsList;
        //系统管理员，拥有最高权限
        if (id == Constant.SUPER_ADMIN) {
            List<SysMenuEntity> menuEntityList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuEntityList.size());
            for (SysMenuEntity menuEntity : menuEntityList) {
                permsList.add(menuEntity.getPerms());
            }
        } else {
            permsList = userMapper.queryAllPerms(id);
        }
        System.out.println(permsList);
        //普通用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            //如果空，执行下一个语句，用于除去空指针异常
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
            System.out.println(permsSet);
        }
    }
}
