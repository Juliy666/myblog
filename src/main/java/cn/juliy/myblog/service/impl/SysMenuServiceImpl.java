package cn.juliy.myblog.service.impl;

import cn.juliy.myblog.entity.SysMenuEntity;
import cn.juliy.myblog.mapper.SysMenuMapper;
import cn.juliy.myblog.service.SysMenuService;
import cn.juliy.myblog.service.UserService;
import cn.juliy.myblog.utills.Constant;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper,SysMenuEntity> implements SysMenuService {
    @Autowired
    private UserService userService;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    public List<SysMenuEntity> getUserMenuList(Long id) {
        //系统管理员的菜单列表，拥有最高权限
        if (id == Constant.SUPER_ADMIN){
            /*直接查出所有的菜单*/
            List<SysMenuEntity> entities = baseMapper.selectList(null);
            return entities;
        }
        return null;
    }
}
