package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.SysMenuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysMenuService extends IService<SysMenuEntity> {
    /*获取用户菜单列表*/
    List<SysMenuEntity> getUserMenuList(Long id);
}
