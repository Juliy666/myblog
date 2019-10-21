package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.UserEntity;
import org.springframework.stereotype.Service;
/**
 * @param
 * @Return
 * @Description 用户
 **/
@Service
public interface UserService{
    /**
     * @param
     * @Return  返回用户id
     * @Description 用户登陆
     **/
    UserEntity login(String username, String password);

}
