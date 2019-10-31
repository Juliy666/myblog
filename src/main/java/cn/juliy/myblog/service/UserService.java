package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @Return
 * @Description 用户
 **/
@Service
public interface UserService extends IService<UserEntity> {
    /**
     * @param
     * @Return  返回用户id
     * @Description 用户登陆
     **/
    UserEntity login(String username, String password);
    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);
}
