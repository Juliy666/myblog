package cn.juliy.myblog.service.impl;

import cn.juliy.myblog.entity.UserEntity;
import cn.juliy.myblog.mapper.UserMapper;
import cn.juliy.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * @param
     * @Return  用户id
     * @Description
     **/
    @Override
    public UserEntity login(String username,String password) {

        List<UserEntity> userEntities = userMapper.selectList(null);
        for (UserEntity userEntity : userEntities) {
            if (userEntity.getUsername().equals(username)&&userEntity.getPassword().equals(password)){
                return userEntity;
            }
        }
        //账户或者密码错误
        return null;
    }
}
